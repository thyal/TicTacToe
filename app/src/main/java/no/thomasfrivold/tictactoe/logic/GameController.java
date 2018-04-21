package no.thomasfrivold.tictactoe.logic;

import no.thomasfrivold.tictactoe.data.Player;

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

    public GameController() {
        this.boardCellsFilled = new boolean[3][3];
    }

    public GameController(int cols, int rows) {
        this.boardCellsFilled = new boolean[cols][rows];
    }

}
