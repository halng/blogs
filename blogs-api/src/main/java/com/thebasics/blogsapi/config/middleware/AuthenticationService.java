package com.thebasics.blogsapi.config.middleware;

import com.thebasics.blogsapi.exceptions.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;


public class AuthenticationService {

    private final static String AUTH_TOKEN_HEADER_NAME = "X-REQUEST-API-TOKEN";

    protected Authentication getAuthentication(HttpServletRequest request) {
        if (request.getRequestURI().contains("admin")) {

            String apiKey = System.getenv("X_API_KEY_THE_BASICS");
            String apiRequestValue = request.getHeader(AUTH_TOKEN_HEADER_NAME);

            if (!StringUtils.isNotEmpty(apiKey) && !StringUtils.isNotEmpty(apiRequestValue)) {
                throw new AuthException("X_API_KEY_THE_BASICS or X-API-KEY is null");
            }

            if (!apiKey.equals(apiRequestValue)) {
                throw new AuthException("Invalid API key");
            }

            return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
        }
        return null;
    }
}
