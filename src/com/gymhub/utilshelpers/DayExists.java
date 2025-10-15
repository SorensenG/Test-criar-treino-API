package com.gymhub.utilshelpers;

import com.gymhub.models.Workout;

import java.util.List;

public class DayExists {
 public static boolean dayExists(String day, List<Workout> workouts) {
    for (Workout w : workouts) {
        if (w.getDay().equalsIgnoreCase(day)) return true;
    }
    return false;
}
    }
