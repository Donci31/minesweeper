package hu.bme.aut.minesweeper.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDao {
    @Query("SELECT * FROM games")
    suspend fun getAll(): List<Game>

    @Query("Delete FROM games")
    suspend fun deleteAll()

    @Insert
    suspend fun insert(game: Game)
}