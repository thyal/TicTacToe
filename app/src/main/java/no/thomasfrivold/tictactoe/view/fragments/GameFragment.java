package no.thomasfrivold.tictactoe.view.fragments;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.data.entities.Player;
import no.thomasfrivold.tictactoe.logic.AIController;
import no.thomasfrivold.tictactoe.data.enums.CellSymbol;
import no.thomasfrivold.tictactoe.logic.GameController;
import no.thomasfrivold.tictactoe.view.dialogs.FinishedGameDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */

public class GameFragment extends Fragment implements View.OnClickListener {

    private Player playerOne;
    private Player playerTwo;
    private GameController gameController;
    private AIController aiController;
    private Chronometer chronometer;

    private ImageButton reset_board,img_btn_01,img_btn_02,img_btn_03,
                        img_btn_11,img_btn_12,img_btn_13,
                        img_btn_21,img_btn_22,img_btn_23;
    private ImageButton[][] mImageButtons;

    private CellSymbol mStartingPlayer;
    private int image;
    private boolean isSinglePlayer;
    private boolean isGameFinished = false;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mStartingPlayer = CellSymbol.CROSS;

        String playerOneName = this.getArguments().getString("playerOne");
        String playerTwoName = this.getArguments().getString("playerTwo");

        if(playerTwoName.equals("TTTBot")) {
            this.isSinglePlayer = true;
        } else {
            this.isSinglePlayer = false;
        }

        playerOne = new Player(playerOneName);
        playerTwo = new Player(playerTwoName);
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_game, container, false);
        initWidgets(v);
        return v;
    }

    //getView() is only available after onCreateView() method has run.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtPlayerOne = getView().findViewById(R.id.txtv_playerOne);
        TextView txtPlayerTwo = getView().findViewById(R.id.txtv_playerTwo);

        txtPlayerOne.setText(playerOne.getName());
        txtPlayerTwo.setText(playerTwo.getName());
    }

    private void initWidgets(View v) {

        image = R.drawable.cross;
        reset_board = v.findViewById(R.id.reset_board);
        img_btn_01 = v.findViewById(R.id.img_btn_01);
        img_btn_02 = v.findViewById(R.id.img_btn_02);
        img_btn_03 = v.findViewById(R.id.img_btn_03);
        img_btn_11 = v.findViewById(R.id.img_btn_11);
        img_btn_12 = v.findViewById(R.id.img_btn_12);
        img_btn_13 = v.findViewById(R.id.img_btn_13);
        img_btn_21 = v.findViewById(R.id.img_btn_21);
        img_btn_22 = v.findViewById(R.id.img_btn_22);
        img_btn_23 = v.findViewById(R.id.img_btn_23);
        mImageButtons = new ImageButton[][]
                {
                        {img_btn_01, img_btn_02, img_btn_03},
                        {img_btn_11,img_btn_12, img_btn_13},
                        {img_btn_21,img_btn_22,img_btn_23}
                };

        gameController = new GameController(mImageButtons, mStartingPlayer, isSinglePlayer);
        //If the game is singleplayer initialize AI.
        if(isSinglePlayer) {
            aiController = new AIController(gameController,1);
        }
        //On Click Listeners
        reset_board.setOnClickListener(this);
        for(ImageButton img_btns[] : mImageButtons) {
            for(ImageButton img_btn : img_btns) {
                img_btn.setOnClickListener(this);
                img_btn.setTag(CellSymbol.BLANK);
            }
        }

        //Chronometer
        chronometer = v.findViewById(R.id.chronometer);
        chronometer.start();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        for(ImageButton img_btns[] : mImageButtons) {
            for(ImageButton img_btn : img_btns) {
                if(viewId == img_btn.getId()) {
                    makeMove(img_btn);
                    if(isSinglePlayer) {
                        if(!isGameFinished) {
                            makeMove(makeAiMove());
                        }

                    }
                }
            }

        }
        if(viewId == reset_board.getId()) {
            resetBoard();
        }
    }

    private void makeMove(ImageButton img_btn) {
        CellSymbol result = gameController.makeMove(img_btn);
        if(result == CellSymbol.BLANK) {
            FinishedGameDialogFragment finishedGameDialogFragment = new FinishedGameDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("winner", result.toString());
            finishedGameDialogFragment.setArguments(bundle);
            finishedGameDialogFragment.show(getFragmentManager(),null);
            chronometer.stop();
            isGameFinished = true;
        }
        if(result != CellSymbol.BLANK && result != null) {
            FinishedGameDialogFragment finishedGameDialogFragment = new FinishedGameDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("winner", result.toString());
            finishedGameDialogFragment.setArguments(bundle);
            finishedGameDialogFragment.show(getFragmentManager(),null);
            chronometer.stop();
            isGameFinished = true;
        }
    }

    public void resetBoard() {
        isGameFinished = false;
        gameController.resetBoard();
        //Restart chronometer. Set base time to NOW.
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    public ImageButton makeAiMove() {
        return aiController.makeEasyMove();
    }

}
