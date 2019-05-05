package com.example.hyte_projekti.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;

@Dao
public interface WorkoutExerciseDAO {

    @Insert
    void insert(WorkoutExercise workoutExercise);

    @Delete
    void delete(WorkoutExercise workoutExercise);

    @Query("SELECT * FROM Exercise WHERE id IN (SELECT exercise_id FROM WorkoutExercise WHERE workout_id=:workoutId)")
    ArrayList<Exercise> getExercisesByWorkoutId(String workoutId);
}
