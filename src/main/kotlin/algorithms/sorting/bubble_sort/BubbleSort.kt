package algorithms.sorting.bubble_sort

/**
 * Performs a bubble sort on an array of integers to sort it in ascending order.
 * Bubble Sort is a simple sorting algorithm that works by comparing and swapping adjacent elements in an array.
 * It iterates through the entire array a certain number of times (based on the number of elements in the array) until the entire array is sorted.
 * @param array the array to sort
 */
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

fun main() {

    val numbers = intArrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    // before sorting
    println(numbers.contentToString())
    bubbleSort(numbers)
    // after sorting
    println(numbers.contentToString())
}