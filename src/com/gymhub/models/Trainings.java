package com.gymhub.models;

import com.gymhub.Dtos.PtInputDTo;
import com.gymhub.utilshelpers.DayExists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trainings {
    private  List<Workout> workouts = new ArrayList<>();

    public Trainings() {}

    public  void addTrain(String day) {
        if (DayExists.dayExists(day,workouts)) {
            System.out.println("Esse dia já existe.");
            return;
        }

        Workout w = new Workout(day);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Qual ex quer adicionar?");
            System.out.print("Nome do exercicio: ");
            String name = scanner.nextLine();
            System.out.print("Musculo: ");
            String muscle = scanner.nextLine();
            System.out.print("Tipo: ");
            String type = scanner.nextLine();
            System.out.print("Dificuldade: ");
            String difficulty = scanner.nextLine();

            PtInputDTo dTo = new PtInputDTo(name, muscle, type, difficulty);
            w.addExercise(dTo);

            System.out.print("Adicionar outro exercício neste dia? (s/n): ");
            String more = scanner.nextLine();
            if (!more.equalsIgnoreCase("s")) break;
        }

        workouts.add(w);
        System.out.println("Workout adicionado: " + day);
    }


    public void addTrainingDay(String day) {
        addTrain(day);
    }

    public void viewTrainingDays() {
        for (Workout w : workouts) System.out.println(w);
    }
}
