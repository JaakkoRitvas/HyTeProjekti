package com.example.hyte_projekti;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ExerciseBodyPartDAO {

    @Insert
    void insert(ExerciseBodyPart exerciseBodyPart);

    @Delete
    void delete(ExerciseBodyPart exerciseBodyPart);

    @Query("SELECT * FROM BodyPart WHERE id IN (SELECT body_part_id FROM ExerciseBodyPart WHERE exercise_id=:exerciseId)")
    List<BodyPart> getBodyPartsByExerciseId(String exerciseId);

    @Query("SELECT * FROM Exercise WHERE id IN (SELECT exercise_id FROM ExerciseBodyPart WHERE body_part_id=:bodyPartId)")
    List<Exercise> getExercisesByBodyPartId(String bodyPartId);
}
