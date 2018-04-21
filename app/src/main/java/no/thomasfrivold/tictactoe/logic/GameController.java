package no.thomasfrivold.tictactoe.logic;

import android.widget.ImageButton;

import no.thomasfrivold.tictactoe.R;

public class GameController {

    /*
     The gameboard is a 3x3 grid

      0 | 1 | 2
      3 | 4 | 5
      6 | 7 | 8

     */

    // will use this array of boolean values to keep track of the board. Sets true if someone has
    // placed a mark on the given spot.
    private boolean[][] boardCellsFilled;
    private int movecounter;
    private int image;
    private ImageButton [] img_btns;
    private CellSymbol mCurrentPlayer;

    public GameController(ImageButton[] img_btns, CellSymbol mCurrentPlayer) {
        this.boardCellsFilled = new boolean[3][3];
        this.img_btns = img_btns;
        this.mCurrentPlayer = mCurrentPlayer;
    }

    public void makeMove(ImageButton img_btn) {
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
        mCurrentPlayer = (mCurrentPlayer == CellSymbol.CROSS) ? CellSymbol.CIRCLE : CellSymbol.CROSS;
    }

}
