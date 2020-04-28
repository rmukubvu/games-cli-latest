package com.spandigital.assessment.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsTest {

    @Test
    void value() {
        assertAll("points_enum_all",
                ()-> assertEquals(1,Points.DRAW.value()),
                ()-> assertEquals(3 ,Points.WIN.value()),
                ()-> assertEquals(0 ,Points.LOSS.value()));
    }
}