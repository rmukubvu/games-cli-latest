package com.spandigital.assessment.processor.receiver;

import com.spandigital.assessment.contract.Reader;
import com.spandigital.assessment.model.ScoresInput;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Hashtable;

public class InputFactory {

    private static Hashtable<String, Reader> processorTable = new Hashtable<>();
    private String key;

    static {
        processorTable.put(ScoresInput.FILE.value(), new ScoreFile());
        processorTable.put(ScoresInput.STDIN.value(), new StandardInput());
    }

    public InputFactory(String key) {
        this.key = key;
    }

    @SneakyThrows
    public Iterable<String> processInput(InputStream in) {
        return processorTable.get(this.key).read(in);
    }
}
