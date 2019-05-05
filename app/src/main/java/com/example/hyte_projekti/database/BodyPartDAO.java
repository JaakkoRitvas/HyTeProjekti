package com.example.hyte_projekti.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BodyPartDAO {

    @Insert
    void insert(BodyPart bodyPart);

    @Delete
    void delete(BodyPart bodyPart);

    @Query("SELECT * FROM BodyPart")
    List<BodyPart> getBodyParts();

    @Query("SELECT * FROM BodyPart WHERE id=:id")
    BodyPart getBodyPartById(String id);
}
