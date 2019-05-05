package com.example.hyte_projekti;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Bodypart {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    private String name;

    public Bodypart() {
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
}
