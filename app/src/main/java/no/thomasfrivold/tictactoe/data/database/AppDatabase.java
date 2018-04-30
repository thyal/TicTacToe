package no.thomasfrivold.tictactoe.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import no.thomasfrivold.tictactoe.data.DAO.PlayerDAO;
import no.thomasfrivold.tictactoe.data.entities.Player;

@Database(entities = {Player.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract PlayerDAO playerDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "player")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public void destroyInstance() {
        INSTANCE = null;
    }
}
