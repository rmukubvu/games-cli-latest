package com.spandigital.assessment.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    private static Team team;

    @BeforeAll
    static void init(){
        team = Team.builder().name("ManUtd").points(3).score(1).build();
    }

    @Test
    void builder() {
        assertAll("builder",
                () -> assertEquals("ManUtd",team.getName()),
                () -> assertTrue(3 == team.getPoints()),
                () -> assertTrue(1 == team.getScore()));
    }

    @Test
    void builder_name_must_not_be_null() {
        assertThrows(NullPointerException.class, () -> {
            team = Team.builder().points(3).build();
        });
    }

    @Test
    void test_to_string_when_no_points_passed() {
        var team2 = Team.builder().name("ManUtd").build();
        assertTrue(team2.toString().equalsIgnoreCase("ManUtd, 0 pts"));
    }

    @Test
    void test_to_string_when_point_is_1_should_be_pt() {
        var team3 = Team.builder().name("ManUtd").points(1).build();
        assertTrue(team3.toString().equalsIgnoreCase("ManUtd, 1 pt"));
    }

    @Test
    void test_to_string() {
        assertTrue(team.toString().equalsIgnoreCase("ManUtd, 3 pts"));
    }

}