package com.gymhub.models;

import com.gymhub.Dtos.ExerciseDto;
import com.gymhub.Dtos.PtInputDTo;
import com.gymhub.api.ninja.ExercisesAPI;
import com.gymhub.utilshelpers.ExerciseSelector;
import com.gymhub.utilshelpers.Printer;

import java.util.List;
import java.util.Scanner;


public class Exercise {
    private String name;
    private String type;
    private String muscle;
    private String equipment;
    private String difficulty;
    private String instructions;

    private Exercise(ExerciseDto dto) {
        this.name = dto.name();
        this.type = dto.type();
        this.muscle = dto.muscle();
        this.equipment = dto.equipment();
        this.difficulty = dto.difficulty();
        this.instructions = dto.instructions();
    }



    public static Exercise fromPtInputs(PtInputDTo dto) {
        try {
            List<ExerciseDto> list = ExercisesAPI.getExercise(dto.namePt(), dto.musclePt(), dto.typePt(), dto.difficultyPt());
            if (list == null || list.isEmpty()) return null;

            Printer.printExercises(list);

            System.out.println("Selecione o número do exercício desejado:");
            Scanner scanner = new Scanner(System.in);
            int selectedIndex = scanner.nextInt();

            ExerciseDto ex = ExerciseSelector.selectExercise(list,selectedIndex);


            Exercise e = new Exercise(ex);


//            System.out.println(e);

    return e;



        } catch (Exception ex) {
            throw new RuntimeException("Erro ao buscar exercício: " + ex.getMessage(), ex);
        }
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", muscle='" + muscle + '\'' +
                ", equipment='" + equipment + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", instructions='" + instructions + '\'' +
                '}' + "\n";
    }

    }




