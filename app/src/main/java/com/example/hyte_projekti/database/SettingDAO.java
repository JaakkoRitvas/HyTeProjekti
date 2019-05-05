package com.example.hyte_projekti.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;

@Dao
public interface SettingDAO {

    @Insert
    void insert(Setting setting);

    @Delete
    void delete(Setting setting);

    @Query("SELECT * FROM Setting WHERE id=:id")
    Setting getSettingById(String id);

    @Query("SELECT * FROM Setting WHERE machine_id=:machineId")
    ArrayList<Setting> getSettingsByMachineId(String machineId);
}
