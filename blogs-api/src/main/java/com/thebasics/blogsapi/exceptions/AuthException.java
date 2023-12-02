package com.thebasics.blogsapi.exceptions;

public class AuthException extends RuntimeException {

    public AuthException() {
        super();
    }

    public AuthException(String msg) {
        super(msg);
    }
}
