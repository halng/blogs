package com.thebasics.blogsapi.config.middleware;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;


public class AuthenticationService {

    private final static String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    @Value("${x.api.key.the.basics}")
    private String API_KEY;

    protected Authentication getAuthentication(HttpServletRequest request) {
        String apiRequestValue = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (API_KEY.equals(apiRequestValue)) {
            throw new BadCredentialsException("Invalid API key");
        }
        return new ApiKeyAuthentication(API_KEY, AuthorityUtils.NO_AUTHORITIES);
    }
}
