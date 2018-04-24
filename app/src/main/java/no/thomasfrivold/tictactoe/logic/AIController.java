package no.thomasfrivold.tictactoe.logic;

import android.widget.ImageButton;

import java.util.Random;

public class AIController {
    private GameController gameController;
    private ImageButton [][] mImageButtons;
    private int difficulty;
    private Random random;

    public AIController(GameController gameController, int difficulty) {
        this.gameController = gameController;
        this.mImageButtons = gameController.getmImageButtons();
        this.difficulty = difficulty;
    }

    public void makeEasyMove() {
        random = new Random();

        int row = random.nextInt(3);
        int col = random.nextInt(3);

        System.out.println(row + " " + col);
        if(mImageButtons[row][col].isClickable()) {
            makeMove(row,col);
        } else {
            makeEasyMove();
        }
    }

    private boolean makeMove(int row, int col) {

        if(mImageButtons[row][col].isClickable()) {
            gameController.makeMove(mImageButtons[row][col]);
            return true;
        }
        return false;
    }
}
