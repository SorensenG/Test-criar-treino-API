package com.gymhub.models;

import com.gymhub.Dtos.PtInputDTo;
import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises = new ArrayList<>();
    private String day;

    public Workout(String day) {
        if (day == null || day.isBlank()) throw new IllegalArgumentException("Day cannot be null or empty");
        this.day = day;
    }

    public void addExercise(PtInputDTo dTo) {
        var ex = Exercise.fromPtInputs(dTo);
        if (ex != null) exercises.add(ex);
    }

    public String getDay() { return day; }

    @Override
    public String toString() {
        return "Workout{" +
                "exercises=" + exercises +
                ", day='" + day + '\'' +
                '}' + "\n";
    }
}
