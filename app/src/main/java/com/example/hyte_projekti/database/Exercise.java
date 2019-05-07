package com.example.hyte_projekti.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Exercise {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "workout_id")
    private String workoutId;

    @NonNull
    private String name;

    public Exercise() {
        id = Integer.toString(hashCode());
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(@NonNull String workoutId) {
        this.workoutId = workoutId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
