# Searching Algorithms in Kotlin

This repository contains implementations of various searching algorithms in Kotlin. Searching is a fundamental operation in computer science, and different algorithms have different time and space complexities.

## Algorithms Included

1. **Linear Search**: A simple search algorithm that finds the position of a target value within a list by checking each element in order.

2. **Binary Search**: An efficient search algorithm for sorted arrays. It works by repeatedly dividing the search interval in half.

3. **Jump Search**: Similar to binary search but makes fewer comparisons by jumping ahead in fixed steps and then performing linear search for the final step.

4. **Interpolation Search**: An improved variant of binary search that works better for uniformly distributed data.

5. **Sequential Search**: A basic search algorithm that checks each element in a list until a match is found.

## Usage

Feel free to use and integrate these searching algorithms into your Kotlin projects. Each algorithm is implemented as an extension function on the `List<T>` or `Array<T>` class.

Example usage:

```kotlin

fun linearSearch(arr: IntArray, key: Int): Int {
    for (i in arr.indices) {
        if (arr[i] == key) {
            return i
        }
    }
    return -1
}

fun sequentialSearch(arr: IntArray, key: Int): Int {
    for ((index, value) in arr.withIndex()) {
        if (value == key) {
            return index
        }
    }
    return -1
}

fun main() {
    
    val arr = intArrayOf(12, 45, 69, 78, 89, 54)
    val result = linearSearch(arr, 69)
    println(result)

    val sequentialSearchResult = sequentialSearch(arr, 12)
    println("Sequential Search Result: $sequentialSearchResult")
}


```

## Contributing
If you'd like to contribute to this project, feel free to open an issue or submit a pull request. Contributions, improvements, and feedback are always welcome!