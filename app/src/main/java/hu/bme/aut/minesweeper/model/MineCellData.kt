package hu.bme.aut.minesweeper.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MineCellData(
    val x: Int,
    val y: Int,
    var value: Int = 0
) {
    var flagged by mutableStateOf(false)
    var revealed by mutableStateOf(false)
}