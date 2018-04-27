package no.thomasfrivold.tictactoe.data.database;

import android.content.Context;

import java.util.List;

import no.thomasfrivold.tictactoe.data.entities.Player;

public class DatabaseHandler {

    public DatabaseHandler() {

    }

    private void addPlayerToLeaderboard(Context context, String playername) {
        Player player = new Player(playername);
        player.setWins(1);

        AppDatabase.getAppDatabase(context).playerDAO().insertAll(player);
    }

    public int checkIfPlayerExsistInDb(Context context, String playername) {
        int playerID = AppDatabase.getAppDatabase(context).playerDAO().getIdFromName(playername);
        if(playerID > 0) {
            return playerID;
        }
        return 0;
    }

    public void addWinToPlayer(Context context,String playername) {
        int playerID = checkIfPlayerExsistInDb(context,playername);
        System.out.println("PLAYERID : " + playerID);
        if(playerID > 0) {
            AppDatabase.getAppDatabase(context).playerDAO().updateWins(playerID);
        } else {
            addPlayerToLeaderboard(context, playername);
        }
    }

    public List<Player> getListFromDb(Context context) {
        return AppDatabase.getAppDatabase(context).playerDAO().getAll();
    }
}
