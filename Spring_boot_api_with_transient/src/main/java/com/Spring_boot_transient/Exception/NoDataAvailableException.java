package com.Spring_boot_transient.Exception;

public class NoDataAvailableException extends RuntimeException{

    String message;

    public NoDataAvailableException(String message)
    {
        super(message);
    }

}
