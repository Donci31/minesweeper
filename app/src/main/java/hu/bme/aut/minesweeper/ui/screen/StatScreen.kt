package hu.bme.aut.minesweeper.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import hu.bme.aut.minesweeper.R
import hu.bme.aut.minesweeper.data.GameRepository
import hu.bme.aut.minesweeper.ui.component.GameStat

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatScreen(
    navController: NavHostController,
    gameRepository: GameRepository,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleLarge,
                        text = stringResource(R.string.stats)
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
                    IconButton(onClick = { gameRepository.deleteAllGames() }) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "deleteIcon",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(gameRepository.allGames) { item ->
                    GameStat(game = item)
                }
            }
        }
    }
}