package com.example.AAD_Final_Course_Work.exception;

public class CropNotFoundException extends RuntimeException{
    public CropNotFoundException() {
        super();
    }

    public CropNotFoundException(String message) {
        super(message);
    }

    public CropNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
