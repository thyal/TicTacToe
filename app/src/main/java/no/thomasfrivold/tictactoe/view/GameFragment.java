package no.thomasfrivold.tictactoe.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.logic.GameController;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements View.OnClickListener {

    private String playerOne;
    private String playerTwo;
    private GameController gameController;

    private ImageButton reset_board,img_btn_01,img_btn_02,img_btn_03,
                        img_btn_11,img_btn_12,img_btn_13,
                        img_btn_21,img_btn_22,img_btn_23;
    private ImageButton[][] img_btns;
    private int mCurrentPlayer;
    private int image;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        gameController = new GameController();
        playerOne = this.getArguments().getString("playerOne");
        playerTwo = this.getArguments().getString("playerTwo");


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

        txtPlayerOne.setText(playerOne);
        txtPlayerTwo.setText(playerTwo);
    }

    private void initWidgets(View v) {
        mCurrentPlayer = 0;
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
        img_btns = new ImageButton[][]
                {
                        {img_btn_01, img_btn_02, img_btn_03},
                        {img_btn_11,img_btn_12, img_btn_13},
                        {img_btn_21,img_btn_22,img_btn_23}
                };

        //On Click Listeners
        reset_board.setOnClickListener(this);
        for(ImageButton img_btn[] : img_btns) {
                for(ImageButton btn : img_btn) {
                    btn.setOnClickListener(this);
                }
        }
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        for(int i = 0; i < img_btns.length; i++) {
            for(int j = 0; j < img_btns[i].length; j++) {
                if(viewId == img_btns[i][j].getId()) {
                    makeMove(i, j);
                }
            }
        }
        if(viewId == reset_board.getId()) {
            resetBoard();
        }
    }

    private void resetBoard() {
        for(ImageButton img_btn[] : img_btns) {
            for(ImageButton btn : img_btn) {
                btn.setImageResource(R.drawable.blank_cell);
                btn.setEnabled(true);
            }

        }
    }

    void makeMove(int col, int row) {

        //gameController.makeMove(col, row);

        if(mCurrentPlayer == 0) {
            image = R.drawable.cross;
            mCurrentPlayer = 1;
        } else {
            image = R.drawable.circle;
            mCurrentPlayer = 0;
        }

        img_btns[col][row].setImageResource(image);
        img_btns[col][row].setEnabled(false);

    }

}
