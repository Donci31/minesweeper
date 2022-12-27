package hu.bme.aut.minesweeper.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class GameState(
    val size: Int
) {
    var gameWon by mutableStateOf(false)
    var gameLost by mutableStateOf(false)
    var flagCounter by mutableStateOf(size)
    var flagCount = 0L

    var ticks = flow {
        while (!gameWon && !gameLost) {
            emit(flagCount++)
            delay(1000)
        }
    }
}
