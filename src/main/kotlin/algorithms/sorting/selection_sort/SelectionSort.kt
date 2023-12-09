package algorithms.sorting.selection_sort

/**
 * Sorts an array of integers using the selection sort algorithm.
 * Selection Sort is a simple sorting algorithm that works by selecting the smallest element of the array and swapping it with the first element.
 * Then, it selects the smallest element of the remaining array and swaps it with the second element, and so on.
 * The algorithm continues to select the smallest element and swap it with an unsorted element until the entire array is sorted.
 *
 * @param array the array to sort
 * @return the sorted array
 */
fun selectionSort(array: IntArray): IntArray {
    for (i in array.indices) {
        // Find the index of the smallest number in the unsorted portion of the array
        var smallest = i
        for (j in i until array.size) {
            if (array[j] < array[smallest]) {
                smallest = j
            }
        }
        // Swap the smallest number with the first number in the unsorted portion of the array
        val temp = array[i]
        array[i] = array[smallest]
        array[smallest] = temp
    }
    return array
}

/*
*  Selection Sort has a time complexity of O(n^2) in all cases, which makes it less efficient compared to some other sorting algorithms.
*  However, it is simple and can be used on small or nearly sorted data sets.
*
*/
fun main() {

    val numbers = intArrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    println(selectionSort(numbers).contentToString())
}