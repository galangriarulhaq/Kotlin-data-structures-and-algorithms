package algorithms.sliding_window.length_of_longest_substring

fun lengthOfLongestSubstring(s: String): Int {
    val charIndexMap = mutableMapOf<Char, Int>()
    var maxLength = 0
    var start = 0

    for (end in s.indices) {
        if (charIndexMap.containsKey(s[end])) {
            // Move 'start' to the position after the last occurrence of the same character
            start = maxOf(start, charIndexMap[s[end]]!! + 1)
        }

        charIndexMap[s[end]] = end
        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}

/*
*  In the above example, the lengthOfLongestSubstring function finds the length of the longest
*  substring without repeated characters in a string using the sliding window technique.
*  This function maintains the character index within the window and slides the window over time.
* */

fun main() {
    val inputString = "abcabcbb"
    val result = lengthOfLongestSubstring(inputString)
    println("Longest substring length without repeated characters: $result")
}
