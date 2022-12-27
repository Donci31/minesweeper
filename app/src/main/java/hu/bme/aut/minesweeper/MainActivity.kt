package hu.bme.aut.minesweeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import hu.bme.aut.minesweeper.data.GameDatabase
import hu.bme.aut.minesweeper.data.GameRepository
import hu.bme.aut.minesweeper.ui.MineSweeperNavHost
import hu.bme.aut.minesweeper.ui.theme.MineSweeperTheme

class MainActivity : ComponentActivity() {

    private lateinit var dataBase : GameDatabase

    private lateinit var gameRepository : GameRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBase = GameDatabase.getDatabase(applicationContext)
        gameRepository = GameRepository(dataBase.gameDao())

        setContent {
            MineSweeperTheme {
                MineSweeperNavHost(gameRepository = gameRepository)
            }
        }
    }
}