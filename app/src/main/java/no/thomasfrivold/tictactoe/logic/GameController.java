package no.thomasfrivold.tictactoe.logic;

import java.util.Arrays;

public class GameController {

    int winnerCombinations[][] = {{0,1,2},{0,3,6},{0,4,8},{3,4,5},{1,4,7},{2,5,8},{2,4,6},{3,4,5}};

    public GameController() {
    }

    public boolean checkWin(int[] row) {
        for(int winnerCombination[] : winnerCombinations) {
            Arrays.sort(winnerCombination);
            Arrays.sort(row);
            System.out.println(row);
            if(Arrays.equals(winnerCombination, row)) {
                System.out.println("WINNER");
                return true;
            } else {
                System.out.println("NOT WIN");
            }
        }
        return false;
    }
}
