package com.spandigital.assessment.helper;

import com.spandigital.assessment.model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class NumberingTest {

    private static List<Team> teamList = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        teamList.add(Team.builder().name("B").points(9).build());
        teamList.add(Team.builder().name("D").points(6).build());
        teamList.add(Team.builder().name("A").points(5).build());
        teamList.add(Team.builder().name("E").points(5).build());
        teamList.add(Team.builder().name("C").points(3).build());
    }

    @Test
    void format() {
        var resultingList = Numbering.format(teamList);
        assertAll("format",
                ()-> assertTrue(resultingList.get(0).startsWith("1."),"Expects 1. at index 0"),
                ()-> assertTrue(resultingList.get(0).contains("B"),"Expects B at index 0"),
                ()-> assertTrue(resultingList.get(1).startsWith("2."),"Expects 2. at index 1"),
                ()-> assertTrue(resultingList.get(2).contains("3."),"Expects 3. at index 2"),
                ()-> assertTrue(resultingList.get(3).startsWith("3."),"Expects 3. at index 3"),
                ()-> assertTrue(resultingList.get(2).contains("A"),"Expects A at index 2"));
    }

    @Test
    void formatList() {
        var resultingList = Numbering.format(teamList);
        assertTrue(Numbering.formatList(resultingList).length() > 0);
    }
}