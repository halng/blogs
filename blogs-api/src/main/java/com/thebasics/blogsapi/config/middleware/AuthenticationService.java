package com.thebasics.blogsapi.config.middleware;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;


public class AuthenticationService {

    private final static String AUTH_TOKEN_HEADER_NAME = "X-REQUEST-API-TOKEN";

    protected Authentication getAuthentication(HttpServletRequest request) {
        if (request.getRequestURI().contains("admin")) {

            String apiKey = System.getenv("X_API_KEY_THE_BASICS");
            String apiRequestValue = request.getHeader(AUTH_TOKEN_HEADER_NAME);

            if (!StringUtils.isNotEmpty(apiKey) && !StringUtils.isNotEmpty(apiRequestValue)) {
                throw new NullPointerException("X_API_KEY_THE_BASICS or X-API-KEY is null");
            }

            if (!apiKey.equals(apiRequestValue)) {
                throw new BadCredentialsException("Invalid API key");
            }

            return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
        }
        return null;
    }
}
