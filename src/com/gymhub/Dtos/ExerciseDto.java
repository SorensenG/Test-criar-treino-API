package com.gymhub.Dtos;

public record ExerciseDto(
        String name,
        String type,
        String muscle,
        String equipment,
        String difficulty,
        String instructions
) {}
