package com.thebasics.blogsapi.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
