package hu.bme.aut.minesweeper.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.bme.aut.minesweeper.R
import hu.bme.aut.minesweeper.data.Game

@Composable
fun GameStat(game: Game) {
    Card(
        modifier = Modifier
            .size(200.dp, 75.dp)
            .padding(bottom = 15.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.displayLarge,
                    text = if (game.gameWon) "\uD83C\uDFC6" else "\u2620\uFE0F"
                )
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.displaySmall,
                    text = "\u2B50".repeat(game.difficulty.ordinal + 1)
                )
            }
            Text(
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.displayMedium,
                text = stringResource(R.string.time,
                    game.time / 60, game.time % 60)
            )
        }
    }
}