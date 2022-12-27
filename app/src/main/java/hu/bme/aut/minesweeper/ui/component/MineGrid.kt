package hu.bme.aut.minesweeper.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.bme.aut.minesweeper.model.MineCellData

@Composable
fun MineGrid(
    mineField: Array<Array<MineCellData>>,
    onCellClicked: (x: Int, y: Int) -> Unit,
    onCellFlagged: (x: Int, y: Int) -> Unit
) {
    Box(
        modifier = Modifier.aspectRatio(1f)
    ) {
        Column {
            for (row in mineField) {
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    for (cell in row) {
                        MineCell(
                            mineCell = cell,
                            onCellClicked = onCellClicked,
                            onCellFlagged = onCellFlagged
                        )
                    }
                }
            }
        }
    }
}