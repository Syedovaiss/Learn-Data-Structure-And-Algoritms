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
    if(array.contains(1).not()) {
        return -1
    }
    var count = 0
    for (item in array) {
        if(item == 1) {
            count++
        } else {
            count = 0
        }
    }
    return count
}
