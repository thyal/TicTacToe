package no.thomasfrivold.tictactoe.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.view.dialogs.SinglePlayerDialogFragment;
import no.thomasfrivold.tictactoe.view.dialogs.TwoPlayerDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuScreenFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "MenuScreenFragment";

    private Button btnSinglePlayer, btnTwoPlayer, btnLeaderboard, btnImage;

    public MenuScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu_screen, container, false);
        initWidgets(v);
        return v;
    }

    private void initWidgets(View v) {
        btnSinglePlayer = v.findViewById(R.id.btn_singleplayer);
        btnTwoPlayer = v.findViewById(R.id.btn_twoplayer);
        btnLeaderboard = v.findViewById(R.id.btn_leaderboard);
        btnImage = v.findViewById(R.id.btn_image);

        btnSinglePlayer.setOnClickListener(this);
        btnTwoPlayer.setOnClickListener(this);
        btnLeaderboard.setOnClickListener(this);
        btnImage.setOnClickListener(this);

}

    private void showSinglePlayerDialog() {
        SinglePlayerDialogFragment singlePlayerDialogFragment = new SinglePlayerDialogFragment();
        singlePlayerDialogFragment.show(getFragmentManager(), "names");
    }

    private void showTwoPlayerDialog() {
        //Dialog
        TwoPlayerDialogFragment twoPlayerDialogFragment = new TwoPlayerDialogFragment();
        twoPlayerDialogFragment.show(getFragmentManager(), "names");
    }


    //Method that will find out which button was clicked, and then send the user to the right fragment.
    @Override
    public void onClick(View v) {

        int viewId = v.getId();

        // TODO find a better way to navigate between fragments (controller-ish class?)
        switch(viewId) {
            case R.id.btn_singleplayer:
                Log.d(TAG, "onClick: singleplayer");
                showSinglePlayerDialog();
                break;
            case R.id.btn_twoplayer:
                Log.d(TAG, "onClick: twoplayer");
                showTwoPlayerDialog();
                break;
            case R.id.btn_leaderboard:
                Log.d(TAG, "onClick: leaderboard");
                LeaderboardFragment leaderboardFragment = new LeaderboardFragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, leaderboardFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_image:
                ImageFragment imageFragment = new ImageFragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, imageFragment)
                        .addToBackStack(null)
                        .commit();
        }

    }
}
