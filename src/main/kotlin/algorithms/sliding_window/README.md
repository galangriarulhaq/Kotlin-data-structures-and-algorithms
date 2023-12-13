# Sliding Window in Kotlin
This repository contains Kotlin implementations of the sliding window technique for solving various algorithmic problems. Sliding window is a powerful algorithmic pattern that involves maintaining a set of elements within a fixed-size window as it moves through an array or string.

## Overview
The sliding window technique is commonly used to optimize solutions for problems related to subarrays, substrings, or other contiguous elements. By efficiently managing a window of elements, we can often achieve solutions with improved time complexity.

## Algorithms Included
1. *Maximum Sum Subarray*

    File: MaxSumSubarray.kt
    Description: Finds the maximum sum of a subarray of a given size.

2. *Longest Substring Without Repeating Characters*

    File: LongestSubstring.kt
    Description: Finds the length of the longest substring without repeating characters.

3. *Count Subarrays with Maximum Sum*

   File: CountMaxSumSubarrays.kt
   Description: Counts the number of subarrays with the maximum sum.

## Usage
Feel free to use and integrate these sliding window algorithms into your Kotlin projects. Each algorithm is implemented as a standalone Kotlin file, making it easy to include only the ones you need.

Example usage:

```kotlin
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

fun main () {
    // Your array and window size
    val arr = intArrayOf(1, 4, 2, 10, 2, 3, 1, 0, 20)
    val k = 4

    // Find the maximum sum subarray
    val result = maxSumSubarray(arr, k)
    println("Maximum sum subarray with size $k is: $result")    
}

```

## Contributing
Contributions are welcome! If you have additional sliding window algorithms or improvements to existing ones, feel free to open an issue or submit a pull request.