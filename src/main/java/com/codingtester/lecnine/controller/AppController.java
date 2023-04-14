package com.codingtester.lecnine.controller;

import android.util.Log;

import com.codingtester.lecnine.model.data.ApiInterface;
import com.codingtester.lecnine.model.pojo.LeagueRoot;
import com.codingtester.lecnine.model.pojo.TeamsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppController {
    private LeagueCallback leagueCallback;
    private TeamsCallBack teamsCallBack;

    public AppController(LeagueCallback leagueCallback) {
        this.leagueCallback = leagueCallback;
    }

    public AppController(TeamsCallBack teamsCallBack) {
        this.teamsCallBack = teamsCallBack;
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getAllLeague() {
        ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);
        Call<LeagueRoot> call = apiInterface.getAllLeague();

        call.enqueue(new Callback<LeagueRoot>() {
            @Override
            public void onResponse(Call<LeagueRoot> call, Response<LeagueRoot> response) {
                leagueCallback.getAllLeague(response.body().leagues);
            }

            @Override
            public void onFailure(Call<LeagueRoot> call, Throwable t) {

            }
        });
    }

    public void getAllTeams(String leagueName) {
        ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);
        Call<TeamsResponse> call = apiInterface.getAllTeamsByLeague(leagueName);

        call.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                teamsCallBack.getAllTeams(response.body().teams);
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                Log.d("rabbit", t.getMessage());
            }
        });
    }


}
