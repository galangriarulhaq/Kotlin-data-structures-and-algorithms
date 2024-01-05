package dynamic_programming.pascal_tri_angel

// generatePascalsTriangle accepts numRows parameter which specifies how many rows of Pascal triangles to generate.
fun generatePascalsTriangle(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    // Using a nested loop, the function builds each row of the Pascal triangle one by one.
    for (i in 0 until numRows) {
        val row = mutableListOf<Int>()

        for (j in 0..i) {
            if (j == 0 || j == i) {
                row.add(1)
            } else {
                // Using dynamic programming to calculate the value of the centre element
                val value = result[i - 1][j - 1] + result[i - 1][j]
                row.add(value)
            }
        }

        result.add(row)
    }

    return result
}

fun main() {
    val numRows = 5
    val pascalsTriangle = generatePascalsTriangle(numRows)

    println("Pascal's Triangle ($numRows rows):")
    for (row in pascalsTriangle) {
        println(row)
    }
}
