package no.thomasfrivold.tictactoe.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import no.thomasfrivold.tictactoe.R;

public class GameActivity extends AppCompatActivity {

    Button btnSinglePlayer;
    Button btnTwoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
