package com.spandigital.assessment.processor.receiver;

import com.spandigital.assessment.contract.Reader;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class StandardInputTest {

    @SneakyThrows
    @Test
    void read() {
        var in = new ByteArrayInputStream("q".getBytes());
        System.setIn(in);
        var r = new StandardInput();
        assertTrue(!r.read(in).iterator().hasNext());
    }

}