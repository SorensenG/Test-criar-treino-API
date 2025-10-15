package com.gymhub.utilshelpers;

import com.gymhub.Dtos.ExerciseDto;

import java.util.List;

public class ExerciseSelector {

    public static ExerciseDto selectExercise(List<ExerciseDto> exercises, int index) {

        if (index < 0 || index >= exercises.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return exercises.get(index);


    }

}
