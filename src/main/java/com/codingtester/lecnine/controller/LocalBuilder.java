package com.codingtester.lecnine.controller;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.codingtester.lecnine.model.data.LeagueDao;
import com.codingtester.lecnine.model.pojo.League;

@Database(entities = League.class, version = 1)
public abstract class LocalBuilder extends RoomDatabase{

    private static LocalBuilder dbInstance;

    public abstract LeagueDao leagueDao();

    public static LocalBuilder getInstance(Context context) {

        if(dbInstance == null) {
            dbInstance = Room.databaseBuilder(context.getApplicationContext(),
                    LocalBuilder.class, "LeaageDB").build();
        }
        return dbInstance;
    }
}





