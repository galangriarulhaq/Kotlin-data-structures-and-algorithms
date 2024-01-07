package dynamic_programming.longest_common_subsequense

class LongestCommonSubsequence(val str1: String, val str2: String) {
    private val len1 = str1.length
    private val len2 = str2.length
    private val dp = Array(len1 + 1) { IntArray(len2 + 1) }

    init {
        // Initialise the entire dp array with the value 0
        for (i in 0..len1) {
            for (j in 0..len2) {
                dp[i][j] = 0
            }
        }
    }

    fun findLCSLength(): Int {
        for (i in 1..len1) {
            for (j in 1..len2) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[len1][len2]
    }

    fun findLCS(): String {
        val result = StringBuilder()
        var i = len1
        var j = len2

        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                result.insert(0, str1[i - 1])
                i--
                j--
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--
            } else {
                j--
            }
        }

        return result.toString()
    }
}

fun main() {
    val str1 = "ABCD"
    val str2 = "ACDF"

    val lcs = LongestCommonSubsequence(str1, str2)
    val lcsLength = lcs.findLCSLength()
    val lcsString = lcs.findLCS()

    println("Length of Longest Common Subsequence: $lcsLength")
    println("Longest Common Subsequence: $lcsString")
}
