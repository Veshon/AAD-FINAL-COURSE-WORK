package com.example.AAD_Final_Course_Work.exception;

public class DataPersistException extends RuntimeException{
    public DataPersistException() {
        super();
    }

    public DataPersistException(String message) {
        super(message);
    }

    public DataPersistException(String message, Throwable cause) {
        super(message, cause);
    }
}
