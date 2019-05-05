package com.example.hyte_projekti;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MachineDAO {

    @Insert
    void insert(Machine machine);

    @Delete
    void delete(Machine machine);

    @Query("SELECT * FROM Machine WHERE exercise_id=:exerciseId")
    List<Machine> getMachinesByExerciseId(String exerciseId);
}
