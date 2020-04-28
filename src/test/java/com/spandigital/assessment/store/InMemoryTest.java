package com.spandigital.assessment.store;

import com.spandigital.assessment.contract.Database;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTest {

    private static Database<Integer> db;

    @BeforeAll
    static void init(){
        db = new InMemory<>();
    }

    void loadData(){
        db.save("a",1);
        db.save("b",2);
        db.save("c",3);
        db.save("d",4);
        db.save("e",5);
    }

    @Test
    void save() {
        loadData();
        var expected = 5;
        var actual = db.count();
        assertTrue(actual == expected);
        db.clear();
    }

    @Test
    void get() {
        loadData();
        var expected = 2;
        var actual = db.get("b");
        assertTrue(actual.get() == expected);
        db.clear();
    }

    @Test
    void update_existing_key() {
        loadData();
        var expected = 2;
        var actual = db.get("b");
        assertTrue(actual.get() == expected);
        db.save("b",45);
        expected = 45;
        actual = db.get("b");
        assertTrue(actual.get() == expected);
        db.clear();
    }

    @Test
    void get_when_key_doesnt_exist_optional_is_present_must_be_false() {
        loadData();
        var actual = db.get("z");
        assertFalse(actual.isPresent());
        db.clear();
    }

    @Test
    void get_when_key_doesnt_exist_must_throw() {
        assertThrows(java.util.NoSuchElementException.class,
                () -> {
                    loadData();
                    db.get("z").get();
                    db.clear();
                });
    }

    @Test
    void getAll() {
        loadData();
        var expected = Arrays.asList(1, 2, 3, 4, 5);
        var actual = db.getAll();
        Stream<Integer> sorted = StreamSupport.stream(actual.spliterator(), false).sorted();
        assertEquals(expected, sorted.collect(Collectors.toList()));
        db.clear();
    }

    @Test
    void count() {
        loadData();
        var expected = 5;
        var actual = db.count();
        assertTrue(actual == expected);
        db.clear();
    }

    @Test
    void count_is_zero_when_cleared() {
        db.clear();
        var expected = 0;
        var actual = db.count();
        assertTrue(actual == expected);
    }


}