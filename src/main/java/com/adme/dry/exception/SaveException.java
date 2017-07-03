package com.adme.dry.exception;

/**
 * Created by Adme System on 6/21/2017.
 */
public class SaveException extends  Exception {
    private String message;

    public SaveException(){

    }
    public SaveException(String message, Throwable cause){
        super(message,cause);
        this.setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
