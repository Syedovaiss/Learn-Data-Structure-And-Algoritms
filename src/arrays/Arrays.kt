package arrays


/**
Second Largest Element in an Array
 **/

fun findSecondLargest(array: Array<Int>): Int {
    if (array.size == 1) {
        return -1
    }
    val secondLargestIndex = array.lastIndex - 1
    return array.sortedArray()[secondLargestIndex]
}

/**
Third Largest Element in an Array
 **/

fun findThirdLargest(array: Array<Int>): Int {
    if (array.size <= 2) {
        return -1
    }
    val thirdLargestIndex = array.lastIndex - 2
    return array.sortedArray()[thirdLargestIndex]
}

/**
Given an integer array, find a maximum product of a triplet in the array.
 **/

fun findMaximumTripletProduct(array: Array<Int>): Int {
    if (array.size <= 2) {
        return -1
    }
    val sorted = array.sortedArray()
    var result = 1
    for (i in sorted.size - 1 downTo 2) {
        result *= sorted[i]
    }
    return result
}

/**
Given a binary array, find the count of a maximum number of consecutive 1s present in the array.
 * **/

fun findMaximumConsecutiveOnes(array: Array<Int>): Int {
    if (array.contains(1).not()) {
        return -1
    }
    var count = 0
    for (item in array) {
        if (item == 1) {
            count++
        } else {
            count = 0
        }
    }
    return count
}

fun isPalindrome(word: String): Boolean {
    var start = 0
    var end = word.length - 1
    while (start < end) {
        if (word[start] != word[end]) {
            return false
        }
        start++
        end--
    }
    return true
}

fun isNearlyPalindrome(word: String): Boolean {
    var isPreviouslyEscaped = false
    var start = 0
    var end = word.length - 1
    while (start < end) {
        if (word[start] != word[end]) {
            if (word[start] == word[end - 1] && isPreviouslyEscaped.not()) {
                isPreviouslyEscaped = true
                end--
            } else if (word[start + 1] == word[end] && isPreviouslyEscaped.not()) {
                isPreviouslyEscaped = true
                start++
            } else {
                return false
            }
        }
        start++
        end--
    }
    return true
}

fun findMax(items: IntArray): Int {
    if (items.isEmpty()) return -1
    var max = items.first()
    items.forEach { item ->
        if (item > max) {
            max = item
        }
    }
    return max
}

fun findSum(items: IntArray): Int {
    if (items.isEmpty()) return -1
    var sum = 0
    items.forEach {
        sum += it
    }
    return sum
}

fun reverseArray(array: IntArray): IntArray {
    if (array.isEmpty()) return intArrayOf()
    val reversed = arrayListOf<Int>()
    for (index in array.size - 1 downTo 0) {
        reversed.add(array[index])
    }
    return reversed.toIntArray()
}

fun containsDuplicate(array: IntArray): Boolean {
    if (array.isEmpty()) return false
    val currentArray = arrayListOf<Int>()
    array.forEach {
        if (currentArray.contains(it)) {
            return true
        }
        currentArray.add(it)
    }
    return false
}

fun removeDuplicate(array: IntArray): ArrayList<Int> {
    if (array.isEmpty()) return arrayListOf()
    val result = arrayListOf<Int>()
    array.forEach {
        if (result.contains(it).not()) {
            result.add(it)
        }
    }
    return result
}

//Problem: Write a function that rotates the array to the right by k steps.
fun rotateAnArray(array: Array<Int>, k: Int): ArrayList<Int> {
    if (array.isEmpty()) return arrayListOf()
    var startStep = k + 1
    val result = arrayListOf<Int>()
    while (startStep != array.size) {
        result.add(array[startStep])
        startStep++
    }
    for (index in 0..k) {
        result.add(array[index])
    }
    return result
}

fun findFirstMissingNumberInSequence(array: Array<Int>, size: Int): Int {
    if (array.isEmpty() && size == 0) return -1
    if (array.isEmpty() && size == 1) return 1
    var result = 0
    for (index in 0..size) {
        if (array.contains(index).not()) {
            result = index
        }
    }
    return result
}

fun findMostRepeatedNumber(array: Array<Int>): Int {
    if (array.isEmpty()) return -1
    val itemsMap = hashMapOf<Int, Int>()
    array.forEach { item ->
        if (itemsMap.containsKey(item)) {
            val lastCount = itemsMap[item]!!.toInt()
            itemsMap[item] = lastCount + 1
        } else {
            itemsMap[item] = 1
        }
    }
    return itemsMap.maxBy { it.value }.key
}