package com.spandigital.assessment.helper;

import com.spandigital.assessment.model.Team;

import java.util.Comparator;
import java.util.List;

public class RankSorting {

    public static void sort(List<Team> teams){
        //sort by points - will sort by asc
        //then reverse to get the sort by desc
        //then sort the names
        teams.sort(Comparator.comparing(Team::getPoints).reversed().thenComparing(Team::getName));
    }
}
