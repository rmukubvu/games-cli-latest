package com.spandigital.assessment.helper;

import com.spandigital.assessment.model.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbering {

    public static List<String> format(List<Team> teams) {
        var at = 0;
        int points;
        var current = 0;
        var list = new ArrayList<String>();
        for (var i = 0; i < teams.size() ; i++ ) {
            Team team = teams.get(i);
            points = team.getPoints();
            if (current != points) {
                at++;
            }
            current = points;
            list.add(String.format("%d. %s", at, team.toString()));

            if (at == i)
                at++;
        }
        return list;
    }

    public static String formatList(List<String> list){
        return list.stream().collect(Collectors.joining("\n"));
    }
}
