package com.spandigital.assessment.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandsTest {

    @Test
    void showAll() {
        assertNotNull(Commands.showAll());
    }
}