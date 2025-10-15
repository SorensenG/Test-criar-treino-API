package com.gymhub.models;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> Exercicios = new ArrayList();


    public void Workout(List<Exercise> exercicios) {
        Exercicios = exercicios;
    }
}
