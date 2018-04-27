package no.thomasfrivold.tictactoe.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import no.thomasfrivold.tictactoe.data.entities.Player;

@Dao
public interface PlayerDAO {

    @Query("SELECT * FROM player ORDER BY wins DESC")
    List<Player> getAll();

    @Query("SELECT id FROM player WHERE name LIKE :name")
    int getIdFromName(String name);

    @Query("UPDATE player SET wins = (wins+1)  WHERE id = :id")
    int updateWins(int id);

    @Insert
    void insertAll(Player...players);

    @Delete
    void delete(Player player);
}
