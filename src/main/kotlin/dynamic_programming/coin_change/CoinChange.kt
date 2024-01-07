package dynamic_programming.coin_change

class CoinChange(val coins: IntArray, val amount: Int) {
    private val numCoins = coins.size
    private val dp = IntArray(amount + 1)

    init {
        // Initialise the entire dp array with an infinite value (representation of no solution)
        for (i in 0..amount) {
            dp[i] = Int.MAX_VALUE
        }

        // A value of 0 is considered achievable with 0 coins
        dp[0] = 0
    }

    fun minCoinsRequired(): Int {
        for (coin in coins) {
            for (i in coin until dp.size) {
                if (dp[i - coin] != Int.MAX_VALUE) {
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }

        return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
    }
}

fun main() {
    val coins = intArrayOf(1, 2, 5)
    val amount = 11

    val coinChange = CoinChange(coins, amount)
    val minCoins = coinChange.minCoinsRequired()

    if (minCoins != -1) {
        println("Minimum number of coins required to make $amount: $minCoins")
    } else {
        println("It is not possible to make $amount with the given coins.")
    }
}
