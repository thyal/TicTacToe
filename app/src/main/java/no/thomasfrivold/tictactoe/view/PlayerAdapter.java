package no.thomasfrivold.tictactoe.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.data.entities.Player;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    List<Player> players;

    public PlayerAdapter(List<Player> players) {
        this.players = players;
        }

    @NonNull
    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_row, parent, false);
            return new ViewHolder(view);
            }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.ViewHolder holder, int position) {
            holder.name.setText(players.get(position).getName());
            holder.wins.setText(players.get(position).getWinsString());
            }

    @Override
    public int getItemCount() {
            return players.size();
            }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView wins;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            wins = itemView.findViewById(R.id.txt_wins);
        }
    }
}
