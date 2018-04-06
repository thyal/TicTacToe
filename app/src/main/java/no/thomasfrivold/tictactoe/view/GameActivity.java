package no.thomasfrivold.tictactoe.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import no.thomasfrivold.tictactoe.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "GameActivity";

    private Button btnSinglePlayer, btnTwoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initWidgets();
    }

    private void initWidgets() {
        btnSinglePlayer = findViewById(R.id.btn_singleplayer);
        btnTwoPlayer = findViewById(R.id.btn_twoplayer);
        btnSinglePlayer.setOnClickListener(this);
        btnTwoPlayer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Find out what was clicked
        int viewId = v.getId();

        if(viewId == R.id.btn_singleplayer) {
            Log.d(TAG, "onClick: singleplayer");
        }
        if(viewId == R.id.btn_twoplayer) {
            Log.d(TAG, "onClick: twoplayer");
        }
    }
}
