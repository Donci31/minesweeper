package hu.bme.aut.minesweeper.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import hu.bme.aut.minesweeper.R

@Composable
fun MenuScreen(
    navController: NavHostController
) {
    Column {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable {
                        navController.navigate(route = "EasyGame")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                    text = stringResource(R.string.easy_game)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        navController.navigate(route = "MediumGame")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                    text = stringResource(R.string.medium_game)
                )
            }
        }

        Row(
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        navController.navigate(route = "HardGame")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                    text = stringResource(R.string.hard_game)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable {
                        navController.navigate(route = "Stats")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                    text = stringResource(R.string.stats)
                )
            }
        }
    }
}