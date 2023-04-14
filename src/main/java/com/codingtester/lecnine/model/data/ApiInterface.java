package com.codingtester.lecnine.model.data;

import com.codingtester.lecnine.model.pojo.LeagueRoot;
import com.codingtester.lecnine.model.pojo.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("all_leagues.php")
    Call<LeagueRoot> getAllLeague();

    @GET("search_all_teams.php")
    Call<TeamsResponse> getAllTeamsByLeague(@Query("l") String strLeague);
}









