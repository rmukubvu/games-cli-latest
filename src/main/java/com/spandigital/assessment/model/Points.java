package com.spandigital.assessment.model;

public enum Points {
    LOSS(0),
    DRAW(1),
    WIN(3);

    private int points;

    Points(int points) {
        this.points = points;
    }

    public int value() {
        return points;
    }
}
