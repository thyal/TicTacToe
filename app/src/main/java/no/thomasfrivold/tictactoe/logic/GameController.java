package no.thomasfrivold.tictactoe.logic;

public class GameController {

    int[][] board;
    int movecounter;

    public GameController() {
        this.board = new int[3][3];
    }

    public GameController(int cols, int rows) {
        this.board = new int[cols][rows];
    }

    public void makeMove(int col, int row) {

    }


}
