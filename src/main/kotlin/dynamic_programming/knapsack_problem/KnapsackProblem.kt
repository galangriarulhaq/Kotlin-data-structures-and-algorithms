package dynamic_programming.knapsack_problem

fun knapsack(weights: IntArray, values: IntArray, capacity: Int): Int {
    val numItems = weights.size
    val dp = Array(numItems + 1) { IntArray(capacity + 1) }

    // Initialise the entire dp array with a value of -1
    for (i in 0..numItems) {
        for (j in 0..capacity) {
            dp[i][j] = -1
        }
    }

    fun knapsackHelper(itemIndex: Int, remainingCapacity: Int): Int {
        // Base: If you have reached the end of the item or have 0 capacity left
        if (itemIndex == 0 || remainingCapacity == 0) {
            return 0
        }

        // If the value is pre-calculated, return the result
        if (dp[itemIndex][remainingCapacity] != -1) {
            return dp[itemIndex][remainingCapacity]
        }

        // Check if items can be put into the knapsack
        if (weights[itemIndex - 1] <= remainingCapacity) {
            // Choose the maximum value between putting or not putting an item into the knapsack
            dp[itemIndex][remainingCapacity] = maxOf(
                values[itemIndex - 1] + knapsackHelper(itemIndex - 1, remainingCapacity - weights[itemIndex - 1]),
                knapsackHelper(itemIndex - 1, remainingCapacity)
            )
            return dp[itemIndex][remainingCapacity]
        } else {
            // If the item does not fit, proceed to the next item
            dp[itemIndex][remainingCapacity] = knapsackHelper(itemIndex - 1, remainingCapacity)
            return dp[itemIndex][remainingCapacity]
        }
    }

    // Call the helper function to get the maximum value
    return knapsackHelper(numItems, capacity)
}

fun main() {
    val weights = intArrayOf(2, 3, 4, 5)
    val values = intArrayOf(3, 4, 5, 6)
    val capacity = 5

    val maxValue = knapsack(weights, values, capacity)

    println("Maximum value in the knapsack: $maxValue")
}
