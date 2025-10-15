package com.gymhub.utilshelpers;

import com.gymhub.Dtos.ExerciseDto;

public final class Printer {
    private Printer() {} // evita instanciar

    public static void printExercises(java.util.List<ExerciseDto> list) {
        var index = 0;
        for (var e : list) {
            System.out.println("Exercise " + (index++) + ":");
            System.out.println(e.name());
            System.out.println("  type: " + e.type());
            System.out.println("  muscle: " + e.muscle());
            System.out.println("  equipment: " + e.equipment());
            System.out.println("  difficulty: " + e.difficulty());
            String instr = e.instructions();
            if (instr != null && !instr.isBlank()) {
                int max = 200;
                System.out.println("  instructions: " + (instr.length() > max ? instr.substring(0, max) + "..." : instr));
            }
            System.out.println();
        }

    }
}