package com.codingtester.lecnine.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtester.lecnine.R;
import com.codingtester.lecnine.controller.AppController;
import com.codingtester.lecnine.controller.TeamsCallBack;
import com.codingtester.lecnine.databinding.FragmentHomeBinding;
import com.codingtester.lecnine.databinding.FragmentTeamsBinding;
import com.codingtester.lecnine.model.pojo.Team;

import java.util.ArrayList;

public class TeamsFragment extends Fragment implements TeamsCallBack {
    TeamsFragmentArgs args;
    private FragmentTeamsBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = TeamsFragmentArgs.fromBundle(getArguments());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        binding = FragmentTeamsBinding.bind(view);

        AppController appController = new AppController(TeamsFragment.this);
        appController.getAllTeams(args.getLeagueName());


        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void getAllTeams(ArrayList<Team> teams) {
        TeamsAdapter adapter = new TeamsAdapter(teams);
        binding.recyclerViewLeague.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.recyclerViewLeague.setAdapter(adapter);
        Log.d("rabbit", teams.get(0).strTeam);
    }
}