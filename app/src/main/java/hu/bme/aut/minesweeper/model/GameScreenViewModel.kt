package hu.bme.aut.minesweeper.model

import androidx.lifecycle.ViewModel
import hu.bme.aut.minesweeper.data.Game


class GameScreenViewModel(
    private val difficulty: GameDifficulty,
    private val saveGame: (Game) -> Unit
) : ViewModel() {
    private val size = difficulty.size

    var mineField = Array(size) { x -> Array(size) { y -> MineCellData(x, y) } }

    var gameState = GameState(size)

    private var revealedCounter = 0

    init {
        var remainingMines = size


        // Generating mines to random positions

        while (remainingMines > 0) {
            val randX = (0 until size).random()
            val randY = (0 until size).random()
            if (mineField[randX][randY].value != -1) {
                mineField[randX][randY].value = -1
                remainingMines--
            }
        }

        // Set values in the grid

        for (row in 0 until size) {
            for (column in 0 until size) {
                if (mineField[row][column].value != -1) {
                    mineField[row][column].value = cellValue(row, column)
                }
            }
        }
    }

    /**
     * Computes cells value at location (x, y)
     *
     * @param x - cells x coordinate
     * @param y - cells y coordinate
     * @return cell value
     */

    private fun cellValue(x: Int, y: Int): Int {
        val truthArray = booleanArrayOf(
            checkNeighbour(x - 1, y),
            checkNeighbour(x - 1, y + 1),
            checkNeighbour(x, y + 1),
            checkNeighbour(x + 1, y + 1),
            checkNeighbour(x + 1, y),
            checkNeighbour(x + 1, y - 1),
            checkNeighbour(x, y - 1),
            checkNeighbour(x - 1, y - 1)
        )

        return truthArray.count { it }
    }

    /**
     * Helper function for determining whether
     * the cell given by (x, y) contains a mine
     *
     * @param x - cells x coordinate
     * @param y - cells y coordinate
     * @return cell has bomb
     */
    private fun checkNeighbour(x: Int, y: Int): Boolean =
        x >= 0 && x <= size - 1 && y >= 0 && y <= size - 1 && mineField[x][y].value == -1

    /**
     * Callback function for handling user clicking on a cell
     *
     * @param x - cells x coordinate
     * @param y - cells y coordinate
     */

    fun onCellRevealed(x: Int, y: Int) {
        // Check if the game has ended
        if (gameState.gameWon || gameState.gameLost) {
            return
        }

        // Check bounds
        if (x < 0 || x > size - 1 || y < 0 || y > size - 1) {
            return
        }

        val curCell = mineField[x][y]

        // Ignore already revealed or flagged cell
        if (curCell.revealed || curCell.flagged) {
            return
        }

        revealedCounter++
        curCell.revealed = true

        // Clicked on bomb
        if (curCell.value == -1) {
            gameState.gameLost = true

            saveGame(
                Game(
                    difficulty = difficulty,
                    gameWon = false,
                    time = gameState.flagCount - 1
                )
            )

            return
        }

        // Enough cells revealed for win
        if (revealedCounter == size * (size - 1)) {
            gameState.gameWon = true

            saveGame(
                Game(
                    difficulty = difficulty,
                    gameWon = true,
                    time = gameState.flagCount - 1
                )
            )

            return
        }

        // Only reveal neighbouring cells when
        // the current cell is not next to a bomb
        if (curCell.value == 0) {
            onCellRevealed(x - 1, y)
            onCellRevealed(x - 1, y + 1)
            onCellRevealed(x, y + 1)
            onCellRevealed(x + 1, y + 1)
            onCellRevealed(x + 1, y)
            onCellRevealed(x + 1, y - 1)
            onCellRevealed(x, y - 1)
            onCellRevealed(x - 1, y - 1)
        }
    }

    /**
     * Callback function for handling user long clicking on a cell
     *
     * @param x - cells x coordinate
     * @param y - cells y coordinate
     */

    fun onCellFlagged(x: Int, y: Int) {
        // Check if the game has ended
        if (gameState.gameWon || gameState.gameLost) {
            return
        }

        val curCell = mineField[x][y]

        // Flags ran out or cell is already revealed
        if (!curCell.flagged && gameState.flagCounter == 0 || curCell.revealed) {
            return
        }

        if (curCell.flagged) {
            gameState.flagCounter++
            curCell.flagged = false
        } else {
            gameState.flagCounter--
            curCell.flagged = true
        }
    }
}