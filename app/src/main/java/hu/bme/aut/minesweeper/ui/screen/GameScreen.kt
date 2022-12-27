package hu.bme.aut.minesweeper.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import hu.bme.aut.minesweeper.R
import hu.bme.aut.minesweeper.data.GameRepository
import hu.bme.aut.minesweeper.model.GameDifficulty
import hu.bme.aut.minesweeper.model.GameScreenViewModel
import hu.bme.aut.minesweeper.model.GameScreenViewModelFactory
import hu.bme.aut.minesweeper.ui.component.*

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    navController: NavHostController,
    difficulty: GameDifficulty,
    gameRepository: GameRepository,
    viewModel: GameScreenViewModel = viewModel(
        factory = GameScreenViewModelFactory(
            difficulty = difficulty,
            saveGame = gameRepository::addGame
        )
    ),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleLarge,
                        text = when (difficulty) {
                            GameDifficulty.EASY_GAME -> stringResource(R.string.easy_game)
                            GameDifficulty.MEDIUM_GAME -> stringResource(R.string.medium_game)
                            GameDifficulty.HARD_GAME -> stringResource(R.string.hard_game)
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "homeIcon",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                ),
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(
                                route = when (difficulty) {
                                    GameDifficulty.EASY_GAME -> "EasyGame"
                                    GameDifficulty.MEDIUM_GAME -> "MediumGame"
                                    GameDifficulty.HARD_GAME -> "HardGame"
                                }
                            ) {
                                popUpTo(route = "Menu")
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "deleteIcon",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Bottom
        ) {
            FlagBoxRow(
                modifier = Modifier.weight(1f),
                gameState = viewModel.gameState
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                FlagText(gameState = viewModel.gameState)

                TimeText(gameState = viewModel.gameState)
            }

            MineGrid(
                mineField = viewModel.mineField,
                onCellClicked = viewModel::onCellRevealed,
                onCellFlagged = viewModel::onCellFlagged
            )
        }
    }
}