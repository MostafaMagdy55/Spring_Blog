package com.spring.blog.exception;

public class UserNameCantBeNull extends RuntimeException{
    public UserNameCantBeNull(String message) {
        super(message);
    }
}
