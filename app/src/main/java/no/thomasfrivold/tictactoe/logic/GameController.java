package no.thomasfrivold.tictactoe.logic;

import android.widget.ImageButton;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.data.enums.CellSymbol;

public class GameController {

    /*
    Controller class. This class handles all of the game logic.

     The gameboard is a 3x3 grid

      0 | 1 | 2
      3 | 4 | 5
      6 | 7 | 8

     */

    private int moveCounter;
    private int image;
    private ImageButton [][] mImageButtons;
    private CellSymbol mCurrentPlayer;
    private boolean isSinglePlayer;
    private boolean gameIsOver;

    public GameController(ImageButton[][] img_btns, CellSymbol mCurrentPlayer, boolean isSinglePlayer) {
        this.mImageButtons = img_btns;
        this.mCurrentPlayer = mCurrentPlayer;
        this.isSinglePlayer = isSinglePlayer;
        this.gameIsOver = false;
    }

    public CellSymbol makeMove(ImageButton img_btn) {
        moveCounter++;
        if(mCurrentPlayer == CellSymbol.CROSS) {
            image = R.drawable.cross;
        } else {
            image = R.drawable.circle;
        }

        img_btn.setImageResource(image);
        img_btn.setTag(mCurrentPlayer);
        img_btn.setEnabled(false);

        /*
        Return current player (symbol) if the game has been won.
        If there is no winner, but the board is full, it means it's a draw. In that case. Return
        the blank symbol.
        If neither of those conditions hit, it means the game is still going. So, change
        player, and return null.
        */
        if(gameIsWon(img_btn)) {
            return mCurrentPlayer;
        }
        else if(boardisFilled()) {
            return CellSymbol.BLANK;
        } else {
            changePlayer();
        }
        return null;
    }

    //Shorthand if statement, just check which player is the current one,
    //and changes the variable to the other.
    private void changePlayer() {
            mCurrentPlayer = (mCurrentPlayer == CellSymbol.CROSS) ? CellSymbol.CIRCLE : CellSymbol.CROSS;
    }

    private boolean boardisFilled() {
        //Get the total amount of cells. since it always will be an equal amount of columns and rows,
        //we can just multiply the two. In a standard game with 3x3 cells, this will equal to 9.

        int boardLength = mImageButtons.length * mImageButtons[0].length;
        int counter = 0;

        //I could also just check if boardLength is equal to moveCounter, but this is safer. Here
        //I am sure that it will only count if there actually is a image (move) made on the cell.
        for(ImageButton img_btns[] : mImageButtons) {
            for(ImageButton img_btn : img_btns) {
                if(img_btn.getTag() != CellSymbol.BLANK) {
                    counter++;
                }
            }
        }
        return boardLength == counter;
    }

    private boolean gameIsWon(ImageButton img_btn) {
        int col,row;
        col = getColumn(img_btn);
        row = getRow(img_btn);

        if(gameIsWonOnRow(col)) {
            gameIsOver = true;
            return true;
        }
        if(gameIsWonOnCol(row)) {
            gameIsOver = true;
            return true;
        }
        if(col == row) {
            if(gameIsWonDiagonally()) {
                gameIsOver = true;
                return true;
            }
        }
        if(col + row == mImageButtons.length -1) {
            if(gameIsWonAntiDiagonally()) {
                gameIsOver = true;
                return true;
            }
        }
        return false;
    }

    private boolean gameIsWonOnRow(int col) {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
                if(mImageButtons[i][col].getTag() == mCurrentPlayer) {
                    symbolsInARow++;
                }
        }
        return mImageButtons.length == symbolsInARow;
    }

    private boolean gameIsWonOnCol(int row) {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons[0].length; i++) {
            if(mImageButtons[row][i].getTag() == mCurrentPlayer) {
                symbolsInARow++;
            }
        }
        return mImageButtons.length == symbolsInARow;
    }

    private boolean gameIsWonDiagonally() {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
            if(mImageButtons[i][i].getTag() == mCurrentPlayer) {
                symbolsInARow++;
            }
        }
        return symbolsInARow == mImageButtons.length;
    }

    private boolean gameIsWonAntiDiagonally() {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
            if(mImageButtons[i][mImageButtons.length - i - 1].getTag() == mCurrentPlayer) {
                symbolsInARow++;
            }
        }
        return symbolsInARow == mImageButtons.length;
    }

    //Methods for getting the row and column of the button pressed.

    private int getRow(ImageButton img_btn) {
        int row = -1;
        for(int i = 0; i < mImageButtons.length; i++) {
            for(int j = 0; j < mImageButtons.length; j++) {
                if(img_btn.getId() == mImageButtons[i][j].getId()) {
                    row = i;
                }
            }
        }
        return row;
    }

    private int getColumn(ImageButton img_btn) {
        int col = -1;
        for(int i = 0; i < mImageButtons.length; i++) {
            for(int j = 0; j < mImageButtons.length; j++) {
                if(img_btn.getId() == mImageButtons[i][j].getId()) {
                    col = j;
                }
            }
        }
        return col;
    }

    public void resetBoard() {
        for(ImageButton img_btns[] : mImageButtons) {
            for(ImageButton img_btn : img_btns) {
                img_btn.setImageResource(R.drawable.blank_cell);
                img_btn.setTag(CellSymbol.BLANK);
                img_btn.setEnabled(true);
            }
        }
    }

    public ImageButton[][] getmImageButtons() {
        return mImageButtons;
    }

    public boolean isGameOver() {
        return gameIsOver;
    }

}