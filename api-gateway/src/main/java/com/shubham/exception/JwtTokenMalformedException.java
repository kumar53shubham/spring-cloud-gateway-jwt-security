package com.shubham.exception;

public class JwtTokenMalformedException extends Throwable {

    public JwtTokenMalformedException(String message) {
        super(message);
    }
}
