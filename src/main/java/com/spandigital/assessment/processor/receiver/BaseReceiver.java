package com.spandigital.assessment.processor.receiver;

import com.spandigital.assessment.model.InvalidCommandException;
import com.spandigital.assessment.model.ScoresInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.spandigital.assessment.model.ScoresInput.*;

public class BaseReceiver {

    public Iterable<String> processInput(String... args) throws InvalidCommandException, FileNotFoundException {
        var key = switch (args.length) {
            case 0 -> STDIN.value();
            case 2 -> FILE.value();
            default -> throw new InvalidCommandException("Invalid input");
        };
        return new InputFactory(key).processInput(getStream(key, args));
    }

    private InputStream getStream(String key, String... args) throws FileNotFoundException {
        //filepath is at args[1] @ args[0] is -f
        return key.equalsIgnoreCase(STDIN.value()) ? System.in : new FileInputStream(new File(args[1]));
    }

}
