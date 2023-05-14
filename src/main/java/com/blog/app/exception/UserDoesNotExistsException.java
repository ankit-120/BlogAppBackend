package com.blog.app.exception;

public class UserDoesNotExistsException extends RuntimeException{

    public UserDoesNotExistsException(String msg){
        super(msg);
    }

}
