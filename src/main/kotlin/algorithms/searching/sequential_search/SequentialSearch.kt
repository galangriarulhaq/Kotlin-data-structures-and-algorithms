package algorithms.searching.sequential_search

class SequentialSearch {

    /**
     * Performs a linear search on an array of integers to find the index of a specified key.
     *
     * @param arr the array to search
     * @param key the value to search for
     * @return the index of the key if it is found, or -1 if it is not found
     *
     * sequential search is not recommended because it takes a significant amount of time to find the target element,
     * especially when the target element is at the end of a data element or the data is not contained within a data element.
     */
    fun sequentialSearch(arr: IntArray, key: Int): Int {
        for ((index, value) in arr.withIndex()) {
            if (value == key) {
                return index
            }
        }
        return -1
    }
}

fun main() {
    val sequential = SequentialSearch()
    val arr = intArrayOf(12, 45, 69, 78, 89, 54)
    val result = sequential.sequentialSearch(arr, 78)
    println(result)
}