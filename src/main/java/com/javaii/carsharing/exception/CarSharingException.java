package com.javaii.carsharing.exception;

public class CarSharingException extends RuntimeException {
    public CarSharingException(String message) {
        super(message);
    }

    public CarSharingException(String message, Exception exception) {
        super(message, exception);
    }
}

