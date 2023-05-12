package com.blog.app.exception;

public class UserExistsException extends RuntimeException{

    public UserExistsException(String msg){
        super(msg);
    }

}
