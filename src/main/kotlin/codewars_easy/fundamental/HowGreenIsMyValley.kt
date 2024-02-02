package codewars_easy.fundamental

fun makeValley(arr: IntArray): IntArray {
    val sortedArr = arr.sorted()
    val result = IntArray(arr.size)

    val mid = (arr.size - 1) / 2
    val leftWing = sortedArr.slice(0..mid).reversed()
    val rightWing = sortedArr.slice(mid + 1 until arr.size)

    var leftIndex = 0
    var rightIndex = 0

    for (i in result.indices) {
        if (i % 2 == 0) {
            result[i] = leftWing[leftIndex++]
        } else {
            result[i] = rightWing[rightIndex++]
        }
    }

    return result
}

fun main() {
    val a1 = intArrayOf(79, 35, 54, 19, 35, 25)
    println("makeValley(${a1.joinToString(", ")}) -> ${makeValley(a1).joinToString(", ")}")

    val a2 = intArrayOf(67, 93, 100, -16, 65, 97, 92)
    println("makeValley(${a2.joinToString(", ")}) -> ${makeValley(a2).joinToString(", ")}")

    val a3 = intArrayOf(66, 55, 100, 68, 46, -82, 12, 72, 12, 38)
    println("makeValley(${a3.joinToString(", ")}) -> ${makeValley(a3).joinToString(", ")}")

    val a4 = intArrayOf(14, 14, 14, 14, 7, 14)
    println("makeValley(${a4.joinToString(", ")}) -> ${makeValley(a4).joinToString(", ")}")

    val a5 = intArrayOf(14, 14, 14, 14, 14)
    println("makeValley(${a5.joinToString(", ")}) -> ${makeValley(a5).joinToString(", ")}")

    val a6 = intArrayOf(17, 17, 15, 14, 8, 7, 7, 5, 4, 4, 1)
    println("makeValley(${a6.joinToString(", ")}) -> ${makeValley(a6).joinToString(", ")}")
}

