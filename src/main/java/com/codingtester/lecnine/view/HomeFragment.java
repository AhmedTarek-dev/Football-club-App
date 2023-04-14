package com.codingtester.lecnine.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtester.lecnine.R;
import com.codingtester.lecnine.controller.AppController;
import com.codingtester.lecnine.controller.LeagueCallback;
import com.codingtester.lecnine.controller.LocalBuilder;
import com.codingtester.lecnine.databinding.FragmentHomeBinding;
import com.codingtester.lecnine.model.pojo.League;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements LeagueCallback, ClickOnFavInterface{

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(view);

        AppController appController = new AppController(HomeFragment.this);
        appController.getAllLeague();

        return binding.getRoot();
    }

    @Override
    public void getAllLeague(ArrayList<League> leagues) {
        LeagueAdapter adapter = new LeagueAdapter(leagues, HomeFragment.this);
        binding.recyclerViewLeague.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.recyclerViewLeague.setAdapter(adapter);
    }

    @Override
    public void addToFavorite(League league) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LocalBuilder localBuilder = LocalBuilder.getInstance(getActivity());
                localBuilder.leagueDao().insertLeague(league);
            }
        }).start();
    }









}





