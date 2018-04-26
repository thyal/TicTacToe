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

    private void makeMove() {
        if(difficulty == 1) {
            makeEasyMove();
        }
    }

    //Easy AI. Just picks a cell randomly.
    public ImageButton makeEasyMove() {

        random = new Random();

        int row = random.nextInt(3);
        int col = random.nextInt(3);

        while(mImageButtons[row][col].getTag() != CellSymbol.BLANK) {
                row = random.nextInt(3);
                col = random.nextInt(3);
        }
        return mImageButtons[row][col];
    }

    //Hard AI
    public void makeHardMove() {
    }

}
