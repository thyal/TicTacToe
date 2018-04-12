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

    void doPositiveClick(String playerOne) {
        Log.d(TAG, playerOne);
    }

    void doNegativeClick() {
        Log.d(TAG, "DIALOG NOT OK");
    }

}
