package com.example.hyte_projekti.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;

@Dao
public interface ExerciseDAO {

    @Insert
    void insert(Exercise exercise);

    @Delete
    void delete(Exercise exercise);

    @Query("SELECT * FROM Exercise")
    ArrayList<Exercise> getExercises();

    @Query("SELECT * FROM Exercise WHERE id=:id")
    Exercise getExerciseById(String id);
}
