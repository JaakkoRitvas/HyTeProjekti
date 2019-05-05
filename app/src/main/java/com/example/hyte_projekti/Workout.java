package com.example.hyte_projekti;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity
public class Workout {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    private Date time;
    private boolean finished;

    public Workout() {
        id = Integer.toString(hashCode());
        finished = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}

