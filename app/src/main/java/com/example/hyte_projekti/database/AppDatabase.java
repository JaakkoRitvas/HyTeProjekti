package com.example.hyte_projekti.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(
        entities = {
                BodyPart.class,
                Exercise.class,
                ExerciseBodyPart.class,
                Machine.class,
                Set.class,
                Setting.class,
                Workout.class,
                WorkoutExercise.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BodyPartDAO bodyPartDAO();
    public abstract ExerciseBodyPartDAO exerciseBodyPartDAO();
    public abstract ExerciseDAO exerciseDAO();
    public abstract MachineDAO machineDAO();
    public abstract SetDAO setDAO();
    public abstract SettingDAO settingDAO();
    public abstract WorkoutDAO workoutDAO();
    public abstract WorkoutExerciseDAO workoutExerciseDAO();
}
