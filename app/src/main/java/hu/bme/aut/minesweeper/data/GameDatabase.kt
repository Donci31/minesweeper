package hu.bme.aut.minesweeper.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [(Game::class)], version = 1)
@TypeConverters(Converters::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        fun getDatabase(applicationContext: Context): GameDatabase {
            return Room.databaseBuilder(
                applicationContext,
                GameDatabase::class.java,
                "games"
            ).build()
        }
    }
}