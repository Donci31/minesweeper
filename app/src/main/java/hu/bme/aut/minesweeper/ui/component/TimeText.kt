package hu.bme.aut.minesweeper.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import hu.bme.aut.minesweeper.R
import hu.bme.aut.minesweeper.model.GameState
import hu.bme.aut.minesweeper.ui.theme.Typography

@Composable
fun TimeText(
    gameState: GameState
) {
    val tick by gameState.ticks.collectAsState(initial = 0)

    Text(
        color = MaterialTheme.colorScheme.onSurface,
        style = Typography.displayLarge,
        text = stringResource(R.string.time, tick / 60, tick % 60)
    )
}