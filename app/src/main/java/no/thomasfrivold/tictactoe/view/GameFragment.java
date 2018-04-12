package no.thomasfrivold.tictactoe.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import no.thomasfrivold.tictactoe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {


    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String playerOne = this.getArguments().getString("playerOne");
        String playerTwo = this.getArguments().getString("playerTwo");

        Log.d("GAMEFRAGMENT", playerOne + " " + playerTwo);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

}
