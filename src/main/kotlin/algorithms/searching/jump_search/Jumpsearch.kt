package algorithms.searching.jump_search

class JumpSearch {

    /**
     * Performs a jump search on an array of integers to find the index of a specified key.
     *
     * @param array the array to search
     * @param target the value to search for
     * @return the index of the key if it is found, or -1 if it is not found
     *
     * Suitable for sorted arrays with a fixed block size.
     * The advantage of Jump Search is that it utilizes the characteristics of a well-ordered data set and can provide good performance in some cases.
     * However, for very large or unordered data sets, other algorithms such as Binary Search may be more efficient.
     */

    fun jumpSearch(array: IntArray, target: Int): Int {
        val blockSize = kotlin.math.sqrt(array.size.toDouble()).toInt()
        var start = 0

        // Jumping to the block where the target might be
        while (start < array.size && array[start] < target) {
            start += blockSize
        }

        // Performing linear search in the last block
        for (i in maxOf(start - blockSize, 0) until minOf(start, array.size)) {
            if (array[i] == target) {
                return i
            }
        }

        // If the target is not found
        return -1
    }
}

fun main() {
    val jump = JumpSearch()
    val array = intArrayOf(10, 25, 32, 45, 55, 68)
    val key = 45
    val result = jump.jumpSearch(array, key)

    println(result)

    if (result != -1) {
        println("Element $key found at index $result")
    } else {
        println("Element $key not found in the array")
    }
}