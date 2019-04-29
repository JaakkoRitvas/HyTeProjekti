package com.example.hyte_projekti;

public class ExerciseBodyPart {
    private String id;
    private String exerciseId;
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
