package algorithms.sliding_window.max_sum_subarray

fun maxSumSubarray(arr: IntArray, k: Int): Int {
    var maxSum = 0
    var currentSum = 0

    // Calculating the initial amount in the first window
    for (i in 0 until k) {
        currentSum += arr[i]
    }

    maxSum = currentSum

    // Moving the windows one by one and counting the number
    for (i in k until arr.size) {
        currentSum = currentSum - arr[i - k] + arr[i]
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}

/*
*  In the above example, the maxSumSubarray function searches for the subarray with the maximum number
*  in the array using the sliding window technique.
*  This function maintains the number of elements in the window and slides the window as time goes by.
* */

fun main() {
    val arr = intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20)
    val k = 4

    val result = maxSumSubarray(arr, k)
    println("The maximum number of subarrays of length $k is: $result")
}
