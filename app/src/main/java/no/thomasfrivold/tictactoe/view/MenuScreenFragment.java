package no.thomasfrivold.tictactoe.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import no.thomasfrivold.tictactoe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuScreenFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "MenuScreenFragment";

    private Button btnSinglePlayer, btnTwoPlayer;

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
        btnSinglePlayer.setOnClickListener(this);
        btnTwoPlayer.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        if(viewId == R.id.btn_singleplayer) {
            Log.d(TAG, "onClick: singleplayer");
        }
        if(viewId == R.id.btn_twoplayer) {
            Log.d(TAG, "onClick: twoplayer");
        }
    }
}
