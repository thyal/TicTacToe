package no.thomasfrivold.tictactoe.view;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import no.thomasfrivold.tictactoe.R;

public class GameActivity extends AppCompatActivity {

    private static final String TAG = "GameActivity";

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        loadMainMenu();
    }


    private void loadMainMenu() {
        Log.d(TAG, "loadMainMenu");

        MenuScreenFragment menuScreenFragment = new MenuScreenFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.container, menuScreenFragment, null)
                .commit();
    }

    void doPositiveClick(String playerOne, String playerTwo) {
        //Log.d(TAG, playerOne + " " + playerTwo);
        Bundle bundle = new Bundle();
        bundle.putString("playerOne", playerOne);
        bundle.putString("playerTwo", playerTwo);

        GameFragment gameFragment = new GameFragment();
        gameFragment.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, gameFragment, null)
                .addToBackStack(null)
                .commit();
}

    void doNegativeClick() {
        Log.d(TAG, "DIALOG NOT OK");
    }

}
