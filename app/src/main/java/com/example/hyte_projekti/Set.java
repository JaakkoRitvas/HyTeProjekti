package com.example.hyte_projekti;

public class Set {
    private String id;
    private String workoutExerciseId;
    private int reps;
    private double weight;


    public Set() {
        id = Integer.toString(hashCode());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkoutExerciseId() {
        return workoutExerciseId;
    }

    public void setWorkoutExerciseId(String workoutExerciseId) {
        this.workoutExerciseId = workoutExerciseId;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
