package dynamic_programming.climb_stairs

// The climbStairs function accepts the parameter n, which is the number of stairs to overcome.
fun climbStairs(n: Int): Int {
    // If n is less than or equal to 2, the number of ways to climb the ladder is n itself.
    // Therefore, we directly return the value of n in this case.
    if (n <= 2) {
        return n
    }

    // Create an array dp (dynamic programming) to store the number of ways to climb each number of stairs from 1 to n.
    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2
    // Use the loop to count the number of ways to climb each number of stairs from 3 to n.
    for (i in 3..n) {
        // The value at each index i is calculated by adding the number of ways to climb i-1 stairs and i-2 stairs.
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}

fun main() {
    val n = 9
    val waysToClimb = climbStairs(n)

    println("Number of ways to climb $n stairs: $waysToClimb")
}
