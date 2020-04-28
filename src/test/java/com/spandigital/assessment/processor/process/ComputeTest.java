package com.spandigital.assessment.processor.process;

import com.spandigital.assessment.store.InMemory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputeTest {

    static List<String> lines = new ArrayList<>(5);

    @BeforeAll
    static void init(){
        lines.add("Lions 3, Snakes 3");
        lines.add("Tarantulas 1, FC Awesome 0");
        lines.add("Lions 1, FC Awesome 1");
        lines.add("Tarantulas 3, Snakes 1");
        lines.add("Lions 4, Grouches 0");
    }

    @Test
    void printLogTable_result_must_not_be_empty() {
        var computeResult = new Compute(new InMemory<>());
        var result = computeResult.printLogTable(lines);
        assertFalse(result.isEmpty());
    }

    @Test
    void printLogTable() {
        var expected = """
                1. Tarantulas, 6 pts
                2. Lions, 5 pts
                3. FC Awesome, 1 pt
                3. Snakes, 1 pt
                5. Grouches, 0 pts""";
        var computeResult = new Compute(new InMemory<>());
        var actual = computeResult.printLogTable(lines);
        assertTrue(expected.equalsIgnoreCase(actual));
    }
}