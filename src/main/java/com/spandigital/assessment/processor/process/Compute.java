package com.spandigital.assessment.processor.process;

import com.spandigital.assessment.contract.Database;
import com.spandigital.assessment.helper.Extract;
import com.spandigital.assessment.helper.Numbering;
import com.spandigital.assessment.helper.RankSorting;
import com.spandigital.assessment.model.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.spandigital.assessment.model.Points.*;
import static com.spandigital.assessment.model.Team.*;

public class Compute {
    private Database<Team> db;

    public Compute(Database<Team> db){
        this.db = db;
    }

    public String printLogTable(final Iterable<String> scores) {
        var teams = new ArrayList<Team>();
        //get the points for each line
        for (String scoreLine : scores) {
            //get list of teams per line
            //2 per line
            teams.addAll(getTeamCollectionFromLine(scoreLine));
            calculatePointsForTeams(teams);
            //clear it
            teams.clear();
        }
        //once done do the sorting to display
        sort(teams);
        //format
        return format(teams);
    }

    private Collection<? extends Team> getTeamCollectionFromLine(String line) {
        var split = line.split(",");
        List<Team> teamList = Arrays.stream(split)
                .map(s -> builder()
                        .name(getTeamName(s))
                        .score(getScore(s))
                        .build()).collect(Collectors.toCollection(() -> new ArrayList<>(2)));
        return teamList;
    }

    private int getSavedPoints(String key){
        var team = db.get(key);
        return team.isPresent() ? team.get().getPoints() : Integer.valueOf(0);
    }

    private void sort(ArrayList<Team> teams) {
        teams.addAll((Collection<? extends Team>) db.getAll());
        RankSorting.sort(teams);
    }

    private String format(ArrayList<Team> teams){
        return Numbering.formatList(Numbering.format(teams));
    }

    private String getTeamName(String line){
        return Extract.stringFromAlphanumeric(line);
    }

    private int getScore(String line){
        return Extract.numberFromAlphanumeric(line);
    }

    private void calculatePointsForTeams(ArrayList<Team> teams) {
        var team1 = teams.get(0);
        var team2 = teams.get(1);

        if (draw(team1, team2)) {
            updateScores(team1, DRAW.value());
            updateScores(team2, DRAW.value());
        } else if (team1Win(team1, team2)) {
            updateScores(team1, WIN.value());
            updateScores(team2, LOSS.value());
        } else {
            updateScores(team1, LOSS.value());
            updateScores(team2, WIN.value());
        }
    }

    private boolean draw(Team team1, Team team2){
        return team1.getScore() == team2.getScore();
    }

    private boolean team1Win(Team team1, Team team2){
        return team1.getScore() > team2.getScore();
    }

    private void updateScores(Team team, int point){
        var newPoints = getSavedPoints(team.getName()) + point;
        team.setPoints(newPoints);
        db.save(team.getName(),team);
    }
}
