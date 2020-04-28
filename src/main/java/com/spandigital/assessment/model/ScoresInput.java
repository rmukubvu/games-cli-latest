package com.spandigital.assessment.model;

public enum ScoresInput {
    FILE("file"),
    STDIN("stdin");

    private String inputName;

    ScoresInput(String inputName) {
        this.inputName = inputName;
    }

    public String value() {
        return inputName;
    }
}
