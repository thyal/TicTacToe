package no.thomasfrivold.tictactoe.logic;

import android.widget.ImageButton;

import java.util.Random;

import no.thomasfrivold.tictactoe.data.enums.CellSymbol;

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
    //It basically checks if player has two in a row somewhere.
    public ImageButton makeHardMove() {

            for(int i = 0; i < mImageButtons.length; i++) {
                if (checkDiagonally() == 2) {
                    if (mImageButtons[i][i].getTag() == CellSymbol.BLANK) {
                        return mImageButtons[i][i];
                    }
                } else if (checkAntiDiagonally() == 2) {
                    if (mImageButtons[i][mImageButtons.length - i - 1].getTag() == CellSymbol.BLANK) {
                        return mImageButtons[i][mImageButtons.length - i - 1];
                    }
                }
                else {
                    if(checkRows(i) == 2) {
                        for(int j = 0; j < mImageButtons.length; j++) {
                            if(mImageButtons[j][i].getTag() == CellSymbol.BLANK) {
                                return mImageButtons[j][i];
                            }
                        }
                    }
                    if(checkCols(i) == 2) {
                        for(int j = 0; j < mImageButtons.length; j++) {
                            if(mImageButtons[i][j].getTag() == CellSymbol.BLANK) {
                                return mImageButtons[i][j];
                            }
                        }
                    }
                }
            }
            return makeEasyMove();
    }





    private int checkRows(int col) {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
            if(mImageButtons[i][col].getTag() == CellSymbol.CROSS) {
                symbolsInARow++;
            }
        }
        return symbolsInARow;
    }

    private int checkCols(int row) {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons[0].length; i++) {
            if(mImageButtons[row][i].getTag() == CellSymbol.CROSS) {
                symbolsInARow++;
            }
        }
        return symbolsInARow;
    }

    private int checkDiagonally() {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
            if(mImageButtons[i][i].getTag() == CellSymbol.CROSS) {
                symbolsInARow++;
            }
        }
        return symbolsInARow;
    }

    private int checkAntiDiagonally() {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
            if(mImageButtons[i][mImageButtons.length - i - 1].getTag() == CellSymbol.CROSS) {
                symbolsInARow++;
            }
        }
        return symbolsInARow;
    }


}
