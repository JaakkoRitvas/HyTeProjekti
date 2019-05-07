package com.example.hyte_projekti.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Exercise {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    private String name;
    private String instructions;

    public Exercise() {
        id = Integer.toString(hashCode());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return name;
    }
}
