package com.example.hyte_projekti.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class ExerciseBodyPart {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "exercise_id")
    @NonNull
    private String exerciseId;

    @ColumnInfo(name = "body_part_id")
    @NonNull
    private String bodyPartId;

    public ExerciseBodyPart() {
        id = Integer.toString(hashCode());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getBodyPartId() {
        return bodyPartId;
    }

    public void setBodyPartId(String bodyPartId) {
        this.bodyPartId = bodyPartId;
    }
}
