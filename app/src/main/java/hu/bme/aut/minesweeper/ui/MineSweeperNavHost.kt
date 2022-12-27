package hu.bme.aut.minesweeper.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hu.bme.aut.minesweeper.data.GameRepository
import hu.bme.aut.minesweeper.model.GameDifficulty
import hu.bme.aut.minesweeper.ui.screen.GameScreen
import hu.bme.aut.minesweeper.ui.screen.MenuScreen
import hu.bme.aut.minesweeper.ui.screen.StatScreen

@Composable
fun MineSweeperNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "Menu",
    gameRepository: GameRepository
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = "Menu") {
            MenuScreen(navController = navController)
        }
        composable(route = "EasyGame") {
            GameScreen(
                navController = navController,
                difficulty = GameDifficulty.EASY_GAME,
                gameRepository = gameRepository
            )
        }
        composable(route = "MediumGame") {
            GameScreen(
                navController = navController,
                difficulty = GameDifficulty.MEDIUM_GAME,
                gameRepository = gameRepository
            )
        }
        composable(route = "HardGame") {
            GameScreen(
                navController = navController,
                difficulty = GameDifficulty.HARD_GAME,
                gameRepository = gameRepository
            )
        }
        composable(route = "Stats") {
            StatScreen(
                navController = navController,
                gameRepository = gameRepository
            )
        }
    }
}
