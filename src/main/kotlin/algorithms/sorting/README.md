# Sorting Algorithms in Kotlin

This repository contains implementations of various sorting algorithms in Kotlin. Sorting is a fundamental operation in computer science, and different algorithms have different time and space complexities.

## Algorithms Included

1. **Bubble Sort**: Simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.

2. **Selection Sort**: In-place comparison-based sorting algorithm. It divides the input into a sorted and an unsorted region, and repeatedly selects the smallest (or largest) element from the unsorted region and swaps it with the first element in the unsorted region.

3. **Insertion Sort**: Efficient algorithm for sorting small datasets. It builds the final sorted array one item at a time, by iteratively taking an element from the input data and inserting it into its correct position.

4. **Merge Sort**: Divide and conquer algorithm that divides the unsorted list into n sub-lists, each containing one element, and then repeatedly merges sub-lists to produce new sorted sub-lists until there is only one sub-list remaining.

5. **Quick Sort**: Another divide and conquer algorithm that works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays according to whether they are less than or greater than the pivot.

## Usage

Feel free to use and integrate these sorting algorithms into your Kotlin projects. Each algorithm is implemented as an extension function on the `MutableList<T>` class.

Example usage:

```kotlin
fun bubbleSort(array: IntArray) {
    // Outer loop iterates over the array indices
    for (i in array.indices) {
        // Inner loop compares adjacent elements of the array and swaps them if
        // they are in the wrong order
        for (j in 0 until array.size - 1) {
            // If the current element is greater than the next element, swap them
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

fun main () {
    val numbers = intArrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    // before sorting
    println(numbers.contentToString())
    bubbleSort(numbers)
    // after sorting
    println(numbers.contentToString())
}
```
## Contributing
If you'd like to contribute to this project, feel free to open an issue or submit a pull request. Contributions, improvements, and feedback are always welcome!