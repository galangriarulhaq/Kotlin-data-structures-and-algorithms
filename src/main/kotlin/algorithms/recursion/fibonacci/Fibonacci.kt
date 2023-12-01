package algorithms.recursion.fibonacci

class Fibonacci {

    // fibonacci recursive
    // Mengembalikan angka ke-n dalam deret Fibonacci menggunakan pendekatan rekursif.
    // @param n posisi angka yang akan diambil (mulai dari 0)
    // @return mengembalikan angka ke-n dalam deret Fibonacci

    fun fibonacciRecursive(n: Int): Int {
        if (n == 0) return 0
        else if (n == 1 || n == 2) return 1
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
    }

    // fibonacci iterative
    // Mengembalikan angka ke-n dalam deret Fibonacci menggunakan pendekatan berulang.
    // @param n posisi angka yang akan diambil (mulai dari 0)
    // @return mengembalikan angka ke-n dalam deret Fibonacci

    fun fibonacciIterative(n: Int): Int {
        return if (n == 0) {
            0
        } else if (n == 1 || n == 2) {
            1
        } else {
            val arr = intArrayOf(1, 1)
            for (i in 3..n) {
                val temp = arr[1]
                arr[1] = arr[0] + arr[1]
                arr[0] = temp
            }
            arr[1]
        }
    }
}

fun main() {
    val fibonacci = Fibonacci()
    val recursive = fibonacci.fibonacciRecursive(5)
    val iterative = fibonacci.fibonacciIterative(5)
    println(recursive)
    println(iterative)
}