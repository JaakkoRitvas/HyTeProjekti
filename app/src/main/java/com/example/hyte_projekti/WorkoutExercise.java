package com.example.hyte_projekti;

public class WorkoutExercise {
    private String id;
    private String workoutId;
    private String exerciseId;

    public WorkoutExercise() {
        id = Integer.toString(hashCode());
    }

    public String getId() {
        return id;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }
}
