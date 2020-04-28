package com.spandigital.assessment.processor.receiver;

import com.spandigital.assessment.contract.Reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreFile implements Reader {

    @Override
    public Iterable<String> read(InputStream inputStream) throws IOException {
        if ( inputStream == null)
            throw new IOException("Please provide a valid file to read");

        ArrayList<String> scores;
        try (var scanner = new Scanner(inputStream)) {
            scores = new ArrayList<>();
            while (scanner.hasNextLine()) {
                scores.add(scanner.nextLine());
            }
        }
        return scores;
    }
}
