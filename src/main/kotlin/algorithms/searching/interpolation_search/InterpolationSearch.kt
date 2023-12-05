package algorithms.searching.interpolation_search

class InterpolationSearch {

    /**
     * Performs an interpolation search on an array of integers to find the index of a specified key.
     *
     * @param array the array to search
     * @param key the value to search for
     * @returns a message indicating the position of its index element if it was found, or if not found returns -1
     */

    fun interpolationSearch(array: IntArray, key: Int): Int {
        var left = 0
        var right = array.size - 1

        while (left <= right && key >= array[left] && key <= array[right]) {
            val pos = left + ((key - array[left]) * (right - left) / (array[right] - array[left]))

            when {
                array[pos] == key -> return pos
                array[pos] < key -> left = pos + 1
                else -> right = pos - 1
            }
        }
        return -1
    }
}

fun main() {
    val interpolation = InterpolationSearch()

    val array = intArrayOf(10, 25, 32, 45, 55, 68)
    val result = interpolation.interpolationSearch(array, 55)
    println(result)

    val result2 = interpolation.interpolationSearch(array, 100)
    println(result2)
}