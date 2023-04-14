package com.codingtester.lecnine.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codingtester.lecnine.R;
import com.codingtester.lecnine.model.pojo.Team;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder>{
    private ArrayList<Team> teams;

    private ClickOnFavInterface clickOnFavInterface;

    public TeamsAdapter(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public TeamsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeamsAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.teams_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsAdapter.ViewHolder holder, int position) {

        Team currentTeam = teams.get(position);

        holder.txtName.setText(currentTeam.strTeam);
        Glide.with(holder.imgLeague).load(currentTeam.strTeamBadge).into(holder.imgLeague);

        holder.cardView.setOnClickListener(view ->  {
            Navigation.findNavController(view)
                    .navigate(TeamsFragmentDirections
                            .actionTeamsFragmentToTeamDetailsFragmenty(currentTeam));
        });


    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgLeague;
        TextView txtName;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLeague = itemView.findViewById(R.id.iv_logo);
            txtName = itemView.findViewById(R.id.txtLeagueName);

            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
