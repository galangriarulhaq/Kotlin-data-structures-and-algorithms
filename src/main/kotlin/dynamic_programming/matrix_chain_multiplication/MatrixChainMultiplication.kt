package dynamic_programming.matrix_chain_multiplication

class MatrixChainMultiplication(val dimensions: IntArray) {
    private val numMatrices = dimensions.size - 1
    private val dp = Array(numMatrices) { IntArray(numMatrices) }

    init {
        for (i in 0 until numMatrices) {
            for (j in 0 until numMatrices) {
                dp[i][j] = -1
            }
        }
    }

    fun minMultiplications(): Int {
        return matrixChainMultiplication(0, numMatrices - 1)
    }

    private fun matrixChainMultiplication(start: Int, end: Int): Int {
        if (start == end) {
            return 0
        }

        if (dp[start][end] != -1) {
            return dp[start][end]
        }

        dp[start][end] = Int.MAX_VALUE

        for (k in start until end) {
            val cost = matrixChainMultiplication(start, k) +
                    matrixChainMultiplication(k + 1, end) +
                    dimensions[start] * dimensions[k + 1] * dimensions[end + 1]

            dp[start][end] = minOf(dp[start][end], cost)
        }

        return dp[start][end]
    }
}

fun main() {
    val dimensions = intArrayOf(30, 35, 15, 5, 10, 20, 25)

    val matrixChainMultiplication = MatrixChainMultiplication(dimensions)
    val minMultiplications = matrixChainMultiplication.minMultiplications()

    println("Minimum number of multiplications: $minMultiplications")
}
