package com.example.hyte_projekti.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ExerciseDAO {

    @Insert
    void insert(Exercise exercise);

    @Delete
    void delete(Exercise exercise);

    @Query("SELECT * FROM Exercise WHERE id=:id")
    Exercise getExerciseById(String id);

    @Query("SELECT * FROM Exercise WHERE workout_id=:workoutId ORDER BY name ASC")
    List<Exercise> getExercisesByWorkoutId(String workoutId);
}
