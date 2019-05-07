package com.example.hyte_projekti.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(
        entities = {
                Exercise.class,
                Workout.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExerciseDAO exerciseDAO();
    public abstract WorkoutDAO workoutDAO();
}
