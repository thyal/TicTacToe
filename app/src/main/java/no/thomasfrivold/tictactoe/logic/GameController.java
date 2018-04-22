package no.thomasfrivold.tictactoe.logic;

import android.widget.ImageButton;
import android.widget.Toast;

import no.thomasfrivold.tictactoe.R;

public class GameController {

    /*
    Controller class. This class handles all of the game logic.

     The gameboard is a 3x3 grid

      0 | 1 | 2
      3 | 4 | 5
      6 | 7 | 8

     */

    // will use this array of boolean values to keep track of the board. Sets true if someone has
    // placed a mark on the given spot.
    private int moveCounter;
    private int image;
    private ImageButton [][] mImageButtons;
    private CellSymbol mCurrentPlayer;

    public GameController(ImageButton[][] img_btns, CellSymbol mCurrentPlayer) {
        this.mImageButtons = img_btns;
        this.mCurrentPlayer = mCurrentPlayer;
    }

    public void makeMove(ImageButton img_btn) {
        moveCounter++;
        if(mCurrentPlayer == CellSymbol.CROSS) {
            image = R.drawable.cross;
        } else {
            image = R.drawable.circle;
        }

        img_btn.setImageResource(image);
        img_btn.setTag(mCurrentPlayer);
        img_btn.setEnabled(false);
        checkIfGameIsWon(img_btn);
        changePlayer();
    }

    //Short if statement, just check which player is the current one,
    //and changes the variable to the other.
    private void changePlayer() {
        if(!boardisFilled()) {
            mCurrentPlayer = (mCurrentPlayer == CellSymbol.CROSS) ? CellSymbol.CIRCLE : CellSymbol.CROSS;
        }
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

    private CellSymbol checkIfGameIsWon(ImageButton img_btn) {
        if(boardisFilled()) {
            System.out.println("DRAW");
            return CellSymbol.BLANK;
        }
        int col,row;
        col = getColumn(img_btn);
        row = getRow(img_btn);

        if(gameIsWonOnRow(col)) {
            System.out.println(mCurrentPlayer + " wins. Three in a row");
            return mCurrentPlayer;
        }
        if(gameIsWonOnCol(row)) {
            System.out.println(mCurrentPlayer + " wins. Three in a col");
            return mCurrentPlayer;
        }

        if(col == row) {
            if(gameIsWonDiagonally()) {
                System.out.println(mCurrentPlayer + " wins. Three diagonally");
                return mCurrentPlayer;
            }
        }

        if(col + row == mImageButtons.length -1) {
            if(gameIsWonAntiDiagonally()) {
                System.out.println(mCurrentPlayer + " wins. Thee ANTI");
            }
        }

        return null;
    }

    private boolean gameIsWonOnRow(int col) {
        int symbolsInARow = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
                if(mImageButtons[i][col].getTag() == mCurrentPlayer) {
                    symbolsInARow++;
                }
        }
        boolean gameWon = mImageButtons.length == symbolsInARow;
        return gameWon;
    }

    private boolean gameIsWonOnCol(int row) {
        int symbolsInACol = 0;
        for(int i = 0; i < mImageButtons[0].length; i++) {
            if(mImageButtons[row][i].getTag() == mCurrentPlayer) {
                symbolsInACol++;
            }
        }
        boolean gameWon = mImageButtons.length == symbolsInACol;
        return gameWon;
    }

    private boolean gameIsWonDiagonally() {
        int symbolsInADig = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
            if(mImageButtons[i][i].getTag() == mCurrentPlayer) {
                symbolsInADig++;
            }
        }
        return symbolsInADig == mImageButtons.length;
    }

    private boolean gameIsWonAntiDiagonally() {
        int symbolsInAnti = 0;
        for(int i = 0; i < mImageButtons.length; i++) {
            if(mImageButtons[i][mImageButtons.length - i - 1].getTag() == mCurrentPlayer) {
                symbolsInAnti++;
            }
        }
        return symbolsInAnti == mImageButtons.length;
    }

    public int getRow(ImageButton img_btn) {
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

    public int getColumn(ImageButton img_btn) {
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

}