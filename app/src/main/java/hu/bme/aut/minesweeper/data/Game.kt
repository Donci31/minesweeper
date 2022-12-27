package hu.bme.aut.minesweeper.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.bme.aut.minesweeper.model.GameDifficulty

@Entity(tableName = "games")
data class Game(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null,

    @ColumnInfo(name = "difficulty")
    var difficulty: GameDifficulty,

    @ColumnInfo(name = "gameWon")
    var gameWon: Boolean,

    @ColumnInfo(name = "time")
    var time: Long,
)
