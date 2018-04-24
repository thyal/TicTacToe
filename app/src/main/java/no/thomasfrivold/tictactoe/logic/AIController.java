package no.thomasfrivold.tictactoe.logic;

import android.widget.ImageButton;

import java.util.Random;

public class AIController {
    private GameController gameController;
    private ImageButton [][] mImageButtons;
    private Random random;

    public AIController(GameController gameController) {
        this.gameController = gameController;
        this.mImageButtons = gameController.getmImageButtons();
    }

    public boolean makeEasyMove() {
        random = new Random();

        int row = random.nextInt(2);
        int col = random.nextInt(2);

        return makeMove(row,col);
    }

    private boolean makeMove(int row, int col) {
        for(int i = 0; i < mImageButtons.length; i++) {
            for(int j = 0; j < mImageButtons[i].length; j++) {
                if(mImageButtons[i][j] == mImageButtons[row][col]) {
                    if(mImageButtons[row][col].isClickable()) {
                        gameController.makeMove(mImageButtons[row][col]);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
