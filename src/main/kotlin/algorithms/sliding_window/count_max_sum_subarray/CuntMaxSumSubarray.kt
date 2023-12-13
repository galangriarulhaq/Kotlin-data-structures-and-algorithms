package algorithms.sliding_window.count_max_sum_subarray

fun countMaxSumSubarrays(arr: IntArray, k: Int): Int {
    var maxSum = 0
    var currentSum = 0
    var count = 0

    // Calculate the initial count in the first window




    for (i in 0 until k) {
        currentSum += arr[i]
    }

    maxSum = currentSum


    // Move the windows one by one and count the sum
    for (i in k until arr.size) {
        currentSum = currentSum - arr[i - k] + arr[i]

        if (currentSum > maxSum) {
            maxSum = currentSum
            count = 1  // Reset the count if a new maximum sum is found
        } else if (currentSum == maxSum) {
            count++    // Add to the count if the same maximum count is found
        }
    }

    return count
}

/*
*  In the above example, the countMaxSumSubarrays function counts the number of subarrays with the
*  maximum number in the array using the sliding window technique.
*  This function also involves a count variable to count the number of times the maximum sum occurs.
* */

fun main() {
    val arr = intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20, 1, 4, 2, 10, 2, 3, 1, 0, 20)
    val k = 4

    val result = countMaxSumSubarrays(arr, k)
    println("Jumlah subarray dengan jumlah maksimum adalah: $result")
}
