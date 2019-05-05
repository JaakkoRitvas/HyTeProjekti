package com.example.hyte_projekti;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SettingDAO {

    @Insert
    void insert(Setting setting);

    @Delete
    void delete(Setting setting);

    @Query("SELECT * FROM Setting WHERE id=:id")
    Setting getSettingById(String id);

    @Query("SELECT * FROM Setting WHERE machine_id=:machineId")
    List<Setting> getSettingsByMachineId(String machineId);
}
