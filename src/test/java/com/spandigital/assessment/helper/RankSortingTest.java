package com.spandigital.assessment.helper;

import com.spandigital.assessment.model.Team;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankSortingTest {

    private static ArrayList<Team> unsortedList = new ArrayList<>();

    @BeforeAll
    static void init(){
        unsortedList.add(Team.builder().name("A").points(5).build());
        unsortedList.add(Team.builder().name("D").points(6).build());
        unsortedList.add(Team.builder().name("C").points(3).build());
        unsortedList.add(Team.builder().name("E").points(5).build());
        unsortedList.add(Team.builder().name("B").points(9).build());
        //then apply sorting
        RankSorting.sort(unsortedList);
        //when sorted should be
        //1.top team is B on index -> 0
        //2.D on index -> 1
        //3.A on index -> 2
        //4.E on index -> 3
        //5.last team is C
    }

    @Test
    void sort_list_must_be_ordered_top_must_be_A() {
        var actual = unsortedList.get(0).getName();
        var errorMessage = String.format("expected B got [%s]", actual);
        assertEquals(actual, "B", errorMessage);
    }

    @Test
    void sort_list_must_be_ordered_top_must_be_C() {
        var lastIndex = unsortedList.size() - 1;
        var actual = unsortedList.get(lastIndex).getName();
        var errorMessage = String.format("expected C got [%s]", actual);
        assertEquals(actual, "C", errorMessage);
    }

    @Test
    void sort_list_must_be_ordered_A_must_be_thirdC() {
        var actual = unsortedList.get(2).getName();
        var errorMessage = String.format("expected A got [%s]", actual);
        assertEquals(actual, "A", errorMessage);
    }

    @Test
    void sort_list_must_be_ordered_alphabetically_with_same_points() {
        List<Team> anotherUnsortedList = new ArrayList<>();
        anotherUnsortedList.add(Team.builder().name("A").points(5).build());
        anotherUnsortedList.add(Team.builder().name("D").points(5).build());
        anotherUnsortedList.add(Team.builder().name("C").points(5).build());
        anotherUnsortedList.add(Team.builder().name("E").points(5).build());
        anotherUnsortedList.add(Team.builder().name("B").points(5).build());
        //then apply sorting
        RankSorting.sort(anotherUnsortedList);

        assertAll("sorted_alphabetically",
                () -> assertEquals("A", anotherUnsortedList.get(0).getName()),
                () -> assertEquals("B", anotherUnsortedList.get(1).getName()),
                () -> assertEquals("C", anotherUnsortedList.get(2).getName()),
                () -> assertEquals("D", anotherUnsortedList.get(3).getName()),
                () -> assertEquals("E", anotherUnsortedList.get(4).getName())
        );
    }

    @Test
    void sort_null_list_must_throw_exception() {
        ArrayList<Team> justAList = null;
        assertThrows(NullPointerException.class,
                () -> RankSorting.sort(justAList));
    }

}