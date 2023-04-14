package com.codingtester.lecnine.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.codingtester.lecnine.R;
import com.codingtester.lecnine.model.pojo.League;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.ViewHolder> {

    private ArrayList<League> leagues;

    private ClickOnFavInterface clickOnFavInterface;

    public LeagueAdapter(ArrayList<League> leagues, ClickOnFavInterface clickOnFavInterface) {
        this.leagues = leagues;
        this.clickOnFavInterface = clickOnFavInterface;
    }

    @NonNull
    @Override
    public LeagueAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.league_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueAdapter.ViewHolder holder, int position) {

        League currentLeague = leagues.get(position);

        holder.txtName.setText(currentLeague.getStrLeague());

        holder.cardView.setOnClickListener(view -> {

            Navigation.findNavController(view)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToTeamsFragment(currentLeague.getStrLeague()));
        });

        switch (currentLeague.getStrSport()) {
            case "Soccer": holder.imgLeague.setImageResource(R.drawable.soccer);
                break;
            case "Motorsport": holder.imgLeague.setImageResource(R.drawable.mottorbike);
                break;
            case "Basketball": holder.imgLeague.setImageResource(R.drawable.basketball);
                break;
            case "Ice Hockey": holder.imgLeague.setImageResource(R.drawable.ice);
                break;
            case "American Football": holder.imgLeague.setImageResource(R.drawable.americanf);
                break;
            case "Rugby": holder.imgLeague.setImageResource(R.drawable.rughby);
                break;
            case "Baseball": holder.imgLeague.setImageResource(R.drawable.baseball);
                break;
            case "Fighting": holder.imgLeague.setImageResource(R.drawable.fihting);
                break;
            case "Cricket": holder.imgLeague.setImageResource(R.drawable.cricket);
                break;
            default: holder.imgLeague.setImageResource(R.drawable.empty);
        }

        holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.imgFav.setImageResource(R.drawable.baseline_favorite_colored_24);
                clickOnFavInterface.addToFavorite(currentLeague);
            }
        });

    }

    @Override
    public int getItemCount() {
        return leagues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFav;
        CircleImageView imgLeague;
        TextView txtName;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFav = itemView.findViewById(R.id.imgFav);
            imgLeague = itemView.findViewById(R.id.iv_logo);
            txtName = itemView.findViewById(R.id.txtLeagueName);

            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}
