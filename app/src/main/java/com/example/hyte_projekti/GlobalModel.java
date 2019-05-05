package com.example.hyte_projekti;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.hyte_projekti.database.AppDatabase;

class GlobalModel {
    private static final GlobalModel ourInstance = new GlobalModel();
    private AppDatabase database;

    static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void activateDatabase(Context context) {
        database = Room.databaseBuilder(context, AppDatabase.class, "LegDayDatabase").build();
    }
}
