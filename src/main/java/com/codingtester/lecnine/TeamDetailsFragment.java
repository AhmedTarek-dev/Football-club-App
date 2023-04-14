package com.codingtester.lecnine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.codingtester.lecnine.databinding.FragmentTeamDetailsFragmentBinding;

public class TeamDetailsFragment extends Fragment {

    TeamDetailsFragmentArgs args;

    FragmentTeamDetailsFragmentBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = TeamDetailsFragmentArgs.fromBundle(getArguments());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTeamDetailsFragmentBinding.inflate(inflater, container, false);

        binding.tvTeams.setText(args.getTeam().strTeam);
        binding.tvDate.setText(String.valueOf(args.getTeam().intFormedYear));

        Glide.with(binding.ivLogo).load(args.getTeam().strTeamBadge).centerCrop().into(binding.ivLogo);
        Glide.with(binding.ivBanner).load(args.getTeam().strStadiumThumb).into(binding.ivBanner);



        binding.btnFacebook.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://" + args.getTeam().strFacebook));
            startActivity(browserIntent);
        });
        binding.button2.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://" + args.getTeam().strYoutube));
            startActivity(browserIntent);
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}