package com.codingtester.lecnine.model.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.codingtester.lecnine.model.pojo.League;

@Dao
public interface LeagueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLeague(League league);

}
