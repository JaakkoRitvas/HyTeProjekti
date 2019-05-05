package com.example.hyte_projekti.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Set {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "workout_exercise_id")
    @NonNull
    private String workoutExerciseId;
    private int reps;
    private double weight;

    public Set() {
        id = Integer.toString(hashCode());
        reps = 0;
        weight = 0;
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
