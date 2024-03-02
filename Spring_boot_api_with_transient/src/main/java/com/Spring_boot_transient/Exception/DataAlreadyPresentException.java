package com.Spring_boot_transient.Exception;

public class DataAlreadyPresentException extends  RuntimeException{

    String message;

    public DataAlreadyPresentException(String message)
    {
        super(message);
    }


}
