package no.thomasfrivold.tictactoe.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.data.database.DatabaseHandler;
import no.thomasfrivold.tictactoe.data.entities.Player;
import no.thomasfrivold.tictactoe.view.PlayerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaderboardFragment extends Fragment {
    private RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<Player> players;


    public LeaderboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        initWidgets(v);
        return v;
    }

    private void initWidgets(View v) {
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DatabaseHandler db = new DatabaseHandler();
        players = db.getListFromDb(getContext());
        adapter = new PlayerAdapter(players);
        recyclerView.setAdapter(adapter);
    }

}
