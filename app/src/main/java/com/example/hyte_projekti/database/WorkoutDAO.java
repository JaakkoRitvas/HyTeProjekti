package com.example.hyte_projekti.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WorkoutDAO {

    @Insert
    void insert(Workout workout);

    @Delete
    void delete(Workout workout);

    @Query("SELECT * FROM Workout WHERE id=:id")
    Workout getWorkoutById(String id);

    @Query("SELECT * FROM Workout ORDER BY date DESC, time DESC")
    List<Workout> getWorkouts();
}
