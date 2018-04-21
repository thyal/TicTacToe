package no.thomasfrivold.tictactoe.logic;

import android.widget.ImageButton;

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
        //Get the total length of cells. since it always will be an equal amount of columns and rows,
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

}
