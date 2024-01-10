package dynamic_programming.edit_distance

class EditDistance(val str1: String, val str2: String) {
    private val len1 = str1.length
    private val len2 = str2.length
    private val dp = Array(len1 + 1) { IntArray(len2 + 1) }

    init {
        for (i in 0..len1) {
            for (j in 0..len2) {
                dp[i][j] = -1
            }
        }
    }

    fun calculateEditDistance(): Int {
        return editDistance(len1, len2)
    }

    private fun editDistance(m: Int, n: Int): Int {
        if (m == 0) {
            return n
        }

        if (n == 0) {
            return m
        }

        if (dp[m][n] != -1) {
            return dp[m][n]
        }

        dp[m][n] = if (str1[m - 1] == str2[n - 1]) {
            editDistance(m - 1, n - 1)
        } else {
            1 + minOf(
                minOf(editDistance(m, n - 1), editDistance(m - 1, n)),
                editDistance(m - 1, n - 1)
            )
        }

        return dp[m][n]
    }
}

fun main() {
    val str1 = "kitten"
    val str2 = "sitting"

    val editDistance = EditDistance(str1, str2)
    val distance = editDistance.calculateEditDistance()

    println("Edit Distance between $str1 and $str2: $distance")
}
