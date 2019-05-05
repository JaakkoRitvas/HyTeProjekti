package com.example.hyte_projekti.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class WorkoutExercise {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "workout_id")
    @NonNull
    private String workoutId;

    @ColumnInfo(name = "exercise_id")
    @NonNull
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
