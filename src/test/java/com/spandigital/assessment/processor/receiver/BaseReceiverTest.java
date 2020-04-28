package com.spandigital.assessment.processor.receiver;

import com.spandigital.assessment.model.InvalidCommandException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.stream.StreamSupport;

class BaseReceiverTest {

    private BaseReceiver baseReceiver = new BaseReceiver();

    @Test
    void processInput_should_throw_invalid_input() {
        Assertions.assertThrows(InvalidCommandException.class,
                ()-> {
                    String[] args = new String[]{"-f"};
                    baseReceiver.processInput(args);
                });
    }

    @Test
    void processInput_should_not_throw_file_not_found() {
        Assertions.assertThrows(FileNotFoundException.class,
                () -> {
                    String[] args = new String[]{"-f", "/scores.txt"};
                    baseReceiver.processInput(args);
                });
    }

    @SneakyThrows
    @Test
    void processInput_should_be_ok() {
        var resource = BaseReceiverTest.class.getResource("/scores.txt");
        var path = Paths.get(resource.toURI());
        String[] args = new String[]{"-f", path.toString()};
        var lines = baseReceiver.processInput(args);
        var count = StreamSupport.stream(lines.spliterator(), false).count();
        Assertions.assertEquals(5, count);
    }
}