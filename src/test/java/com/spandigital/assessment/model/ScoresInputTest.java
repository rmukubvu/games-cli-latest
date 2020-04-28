package com.spandigital.assessment.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoresInputTest {

    @Test
    void value() {
        assertAll("score_enum_all",
                ()-> assertEquals("file",ScoresInput.FILE.value()),
                ()-> assertEquals("stdin" ,ScoresInput.STDIN.value()));
    }
}