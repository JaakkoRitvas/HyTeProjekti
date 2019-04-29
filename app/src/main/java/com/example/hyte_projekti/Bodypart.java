package com.example.hyte_projekti;

public class Bodypart {
    private String id;
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
