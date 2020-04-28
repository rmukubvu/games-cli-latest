package com.spandigital.assessment.helper;

import lombok.Builder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ExtractTest {

    private static ArrayList<TestResults> testData = new ArrayList<>(5);

    @BeforeAll
    static void init(){
        testData.add(TestResults.builder().testInput("abcher1234efhajk4567").expectedString("abcherefhajk").expectedInt(12344567).build());
        testData.add(TestResults.builder().testInput("123456789").expectedString("").expectedInt(123456789).build());
        testData.add(TestResults.builder().testInput("!@#$%%%^456892").expectedString("!@#$%%%^").expectedInt(456892).build());
        testData.add(TestResults.builder().testInput("~?()$%^&").expectedString("~?()$%^&").expectedInt(0).build());
        testData.add(TestResults.builder().testInput("A String 1234 Take45").expectedString("A String  Take").expectedInt(123445).build());
    }

    @Test
    void numberFromAlphanumeric() {
        for (TestResults testDatum : testData) {
            int actual = Extract.numberFromAlphanumeric(testDatum.testInput);
            String errorMessage = String.format("expected [%d] got [%d]", testDatum.expectedInt, actual);
            assertEquals(actual, testDatum.expectedInt, errorMessage);
        }
    }

    @Test
    void stringFromAlphanumeric() {
        for (TestResults testDatum : testData) {
            String actual = Extract.stringFromAlphanumeric(testDatum.testInput);
            String errorMessage = String.format("expected [%s] got [%s]", testDatum.expectedString, actual);
            assertEquals(actual, testDatum.expectedString, errorMessage);
        }
    }

    @Builder
    static class TestResults{
        String testInput;
        String expectedString;
        int expectedInt;
    }
}