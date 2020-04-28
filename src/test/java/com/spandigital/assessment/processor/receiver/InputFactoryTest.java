package com.spandigital.assessment.processor.receiver;

import com.spandigital.assessment.model.ScoresInput;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputFactoryTest {

    @Test
    void processInput_has_next() {
        var in = InputFactoryTest.class.getResourceAsStream("/scores.txt");
        var factory = new InputFactory(ScoresInput.FILE.value());
        var result = factory.processInput(in);
        assertTrue(result.iterator().hasNext());
    }

    @Test
    void processInput_invalid_file_name_throw_exception() {
        assertThrows(IOException.class, ()-> {
            var in = InputFactoryTest.class.getResourceAsStream("/scores222.txt");
            var factory = new InputFactory(ScoresInput.FILE.value());
            var result = factory.processInput(in);
            result.iterator().hasNext();
        });
    }
}