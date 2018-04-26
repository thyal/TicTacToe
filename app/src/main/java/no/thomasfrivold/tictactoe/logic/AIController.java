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

    private void makeMove(int row, int col) {
        gameController.makeMove(mImageButtons[row][col]);
    }

    //Easy AI
    public ImageButton makeEasyMove() {

        ImageButton[][] latestButtons = gameController.getmImageButtons();

        random = new Random();

        int row = random.nextInt(3);
        int col = random.nextInt(3);

        while(latestButtons[row][col].getTag() != CellSymbol.BLANK) {
                row = random.nextInt(3);
                col = random.nextInt(3);
        }
        return latestButtons[row][col];
    }

    //Hard AI
    public void makeHardMove() {

    }

}
