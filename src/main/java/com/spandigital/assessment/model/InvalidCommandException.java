package com.spandigital.assessment.model;

public class InvalidCommandException extends Exception {

    public InvalidCommandException() {
    }

    public InvalidCommandException(String message){
        super(message);
    }
}
