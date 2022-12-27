package hu.bme.aut.minesweeper.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.minesweeper.data.Game

@Suppress("UNCHECKED_CAST")
class GameScreenViewModelFactory(
    private val difficulty: GameDifficulty,
    private val saveGame: (Game) -> Unit
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        GameScreenViewModel(difficulty, saveGame) as T
}