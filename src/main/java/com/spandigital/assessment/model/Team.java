package com.spandigital.assessment.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @NonNull private String name;
    private Integer score;
    //default value for point so that toString will not show
    //example Barcelona, null pts
    @Builder.Default private Integer points = 0;

    @Override
    public String toString() {
        var suffix = points == 1 ? "pt" : "pts";
        return String.format("%s, %d %s", name, points, suffix);
    }
}
