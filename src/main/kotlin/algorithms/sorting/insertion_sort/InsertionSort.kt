package algorithms.sorting.insertion_sort

/**
 * Performs an insertion sort on an ArrayList of integers to sort it in ascending order.
 * Insertion Sort is a sorting algorithm that builds a sorted sequence one element at a time.
 * It works by comparing each element with the already sorted elements and inserting it into the correct position.
 *
 *  @param array the ArrayList to sort
 */
fun insertionSort(array: ArrayList<Int>) {
    // Iterate over the indices of the input array
    for (i in array.indices) {
        // If the current number is less than or equal to the first number, insert it at the beginning of the array
        if (array[i] <= array[0]) {
            array.add(0, array.removeAt(i))
        } else {
            // If the current number is less than the previous number, find the correct position to insert it
            if (array[i] < array[i - 1]) {
                // Iterate over the array from the second number to the current number
                for (j in 1 until i) {
                    // If the current number is less than the j-th number, insert it at that position
                    if (array[i] < array[j]) {
                        array.add(j, array.removeAt(i))
                        break
                    }
                }
            }
        }
    }
}

/*
*  Insertion Sort has a time complexity of O(n^2) in the worst case, but tends to perform well for data sets
*  that are nearly ordered or have a small number of elements. Although not as fast as some other sorting algorithms,
*  Insertion Sort has the advantage of being able to perform in-place sorting without requiring additional space.
*/

fun main() {
    val numbers = ArrayList(listOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0))
    // before
    println(numbers)

    insertionSort(numbers)

    // after
    println(numbers)
}
