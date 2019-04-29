package com.example.hyte_projekti;

import java.util.Date;

public class Workout {
    private String id;
    private Date time;

    public Workout() {
        id = Integer.toString(hashCode());
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
}

