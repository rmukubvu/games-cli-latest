package com.spandigital.assessment.processor.receiver;

import com.spandigital.assessment.contract.Reader;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

class ScoreFileTest {

    @SneakyThrows
    @Test
    void read_has_next() {
        Reader r = new ScoreFile();
        InputStream in = ScoreFileTest.class.getResourceAsStream("/scores.txt");
        assertTrue(r.read(in).iterator().hasNext());
    }

    @SneakyThrows
    @Test
    void read_has_5_items() {
        var r = new ScoreFile();
        var in = ScoreFileTest.class.getResourceAsStream("/scores.txt");
        var items = r.read(in);
        var count = StreamSupport.stream(items.spliterator(),false).count();
        assertEquals(5, count);
    }

    @Test
    void read_invalid_file_name_throw_exception() {
        assertThrows(IOException.class, ()-> {
            var r = new ScoreFile();
            var in = ScoreFileTest.class.getResourceAsStream("/scores111.txt");
            var items = r.read(in);
            var count = StreamSupport.stream(items.spliterator(),false).count();
            assertEquals(5, count);
        });
    }
}