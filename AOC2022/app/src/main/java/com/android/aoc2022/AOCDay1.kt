package com.android.aoc2022

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly

@Preview
@Composable
fun AOCDay1Preview() {
    AOCDay1()
}

@Composable
fun AOCDay1() {
    val dayNum = 1

    val formattedInput = formatStringByLineThenByNumber(day1RawInput)

    AOCDay1Part1(formattedInput)
    AOCDay1Part2(formattedInput)
}

fun formatStringByLineThenByNumber(strInput: String): List<List<Int>> {
    val formattedInput = mutableListOf<List<Int>>()

    var chunk = mutableListOf<Int>()
    strInput.split("\n").forEach {
        if(it.toIntOrNull() != null) {
            chunk.add(it.toInt())
        }
        else {
            if(chunk.isNotEmpty()) {
                formattedInput.add(chunk.toList())
                chunk = mutableListOf<Int>()
            }
        }
    }

    return formattedInput.toList()
}

fun sumIntList(intList: List<Int>): Int {
    var total = 0
    intList.forEach {
         total += it
    }
    return total
}

fun findLargestSumOfIntLists(listOfIntLists: List<List<Int>>): Int {
    var largestSum = 0
    listOfIntLists.forEach {
        val currentSum = sumIntList(it)
        if(currentSum > largestSum) {
            largestSum = currentSum
        }
    }
    return largestSum
}

@Composable
fun AOCDay1Part1(input: List<List<Int>>) {
    val part1Answer = findLargestSumOfIntLists(input)

    Log.v("Answer", "Part 1 Answer: $part1Answer")
}

fun findSumOfLargestNOfIntLists(listOfIntLists: List<List<Int>>, numOfSums: Int): Int {
    var topSums = mutableListOf<Int>()

    listOfIntLists.forEach {
        val currentSum = sumIntList(it)
        topSums.add(currentSum)
        topSums.sort()
        topSums.reverse()
        if(topSums.count() > numOfSums)
            topSums = topSums.dropLast(1) as MutableList<Int>
    }

    return sumIntList(topSums.toList())
}

@Composable
fun AOCDay1Part2(input: List<List<Int>>) {
    val part2Answer = findSumOfLargestNOfIntLists(input, 3)

    Log.v("Answer", "Part 2 Answer: $part2Answer")
}