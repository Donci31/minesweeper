package hu.bme.aut.minesweeper.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import hu.bme.aut.minesweeper.R
import hu.bme.aut.minesweeper.model.MineCellData

@Composable
fun MineCell(
    mineCell: MineCellData,
    onCellClicked: (x: Int, y: Int) -> Unit,
    onCellFlagged: (x: Int, y: Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(
                color = if (mineCell.revealed) {
                    MaterialTheme.colorScheme.secondary
                } else {
                    MaterialTheme.colorScheme.primary
                }
            )
            .border(BorderStroke(3.dp, MaterialTheme.colorScheme.outline))
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onCellClicked(mineCell.x, mineCell.y)
                    },
                    onLongPress = {
                        onCellFlagged(mineCell.x, mineCell.y)
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        if (mineCell.flagged) {
            Image(
                painter = painterResource(R.drawable.flag),
                contentDescription = "Flag"
            )
        } else if (mineCell.revealed && mineCell.value == -1) {
            Image(
                painter = painterResource(R.drawable.bomb),
                contentDescription = "Flag"
            )
        } else {
            Text(
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.displayMedium,
                text = if (!mineCell.revealed || mineCell.value == 0) {
                    ""
                } else {
                    mineCell.value.toString()
                }
            )
        }
    }
}