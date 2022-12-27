package hu.bme.aut.minesweeper.data

import androidx.room.TypeConverter
import hu.bme.aut.minesweeper.model.GameDifficulty

class Converters {

    @TypeConverter
    fun toHealth(value: Int) = enumValues<GameDifficulty>()[value]

    @TypeConverter
    fun fromHealth(value: GameDifficulty) = value.ordinal
}