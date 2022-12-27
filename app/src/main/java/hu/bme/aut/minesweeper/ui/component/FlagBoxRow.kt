package hu.bme.aut.minesweeper.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import hu.bme.aut.minesweeper.R
import hu.bme.aut.minesweeper.model.GameState

@Composable
fun FlagBoxRow(
    modifier: Modifier = Modifier,
    gameState: GameState
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val boxSize = screenWidth / (gameState.size + 2)

    Row(
        modifier = modifier.padding(start = boxSize, end = boxSize),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until gameState.flagCounter) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .size(boxSize)
                    .border(BorderStroke(3.dp, MaterialTheme.colorScheme.outline)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.flag),
                    contentDescription = "Flag"
                )
            }
        }
    }
}