package com.example.hyte_projekti.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Setting {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "machine_id")
    @NonNull
    private String machineId;

    @NonNull
    private String name;
    private double value;

    public Setting() {
        id = Integer.toString(hashCode());
        value = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
