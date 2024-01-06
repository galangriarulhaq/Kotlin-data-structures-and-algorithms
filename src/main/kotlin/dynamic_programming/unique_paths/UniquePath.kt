package dynamic_programming.unique_paths

class UniquePaths(m: Int, n: Int) {
    private val rows = m
    private val cols = n
    private val dp = Array(rows) { IntArray(cols) }

    init {
        // Initialise the entire dp array with a value of -1
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                dp[i][j] = -1
            }
        }
    }

    fun countUniquePaths(): Int {
        return countPaths(0, 0)
    }

    private fun countPaths(row: Int, col: Int): Int {
        // Base: If it reaches the right or bottom end cell, there is only one way
        if (row == rows - 1 || col == cols - 1) {
            return 1
        }

        // If the value is pre-calculated, return the result
        if (dp[row][col] != -1) {
            return dp[row][col]
        }

        // Calculate the number of ways from the next (bottom and right) using recursion
        dp[row][col] = countPaths(row + 1, col) + countPaths(row, col + 1)

        // Return the calculated result
        return dp[row][col]
    }
}

fun main() {
    val uniquePaths = UniquePaths(3, 7)
    val count = uniquePaths.countUniquePaths()

    println("Number of unique paths: $count")
}
