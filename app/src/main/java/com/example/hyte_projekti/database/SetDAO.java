package com.example.hyte_projekti.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SetDAO {

    @Insert
    void insert(Set set);

    @Delete
    void delete(Set set);

    @Query("SELECT * FROM `Set` WHERE id=:id")
    Set getSetById(String id);

    @Query("SELECT * FROM `Set` WHERE workout_exercise_id=:workoutExerciseId")
    List<Set> getSetsByWorkoutExerciseId(String workoutExerciseId);
}
