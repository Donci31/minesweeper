package hu.bme.aut.minesweeper.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import hu.bme.aut.minesweeper.R
import hu.bme.aut.minesweeper.model.GameState
import hu.bme.aut.minesweeper.ui.theme.Typography

@Composable
fun FlagText(
    gameState: GameState
) {
    Text(
        color = MaterialTheme.colorScheme.onSurface,
        style = Typography.displayLarge,
        text = stringResource(R.string.flags, gameState.flagCounter)
    )
}