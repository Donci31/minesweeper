package hu.bme.aut.minesweeper.data

import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameRepository(private val gameDao: GameDao) {

    var allGames = mutableStateListOf<Game>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        getAllGames()
    }

    fun addGame(newGame: Game) {
        allGames.add(0, newGame)

        coroutineScope.launch(Dispatchers.IO) {
            gameDao.insert(newGame)
        }
    }

    fun deleteAllGames() {
        allGames.clear()

        coroutineScope.launch(Dispatchers.IO) {
            gameDao.deleteAll()
        }
    }

    private fun getAllGames() {
        coroutineScope.launch(Dispatchers.IO) {
            allGames.addAll(gameDao.getAll().reversed())
        }
    }
}