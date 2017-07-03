package com.adme.dry.exception;

/**
 * Created by Adme System on 6/21/2017.
 */
public class NotFoundException extends Exception {
    public NotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
