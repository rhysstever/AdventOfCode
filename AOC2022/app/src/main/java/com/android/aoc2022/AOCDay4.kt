package com.android.aoc2022

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AOCDay4Preview() {
    AOCDay4()
}

@Composable
fun AOCDay4() {
    val dayNum = 4

    val formattedInput = formatInput(day4RawInput)

    AOCDay4Part1(formattedInput)
    AOCDay4Part2(formattedInput)
}

fun formatInput(input: String): List<List<List<Int>>> {
    val formattedInput = mutableListOf<List<List<Int>>>()
    val linedInput = input.split('\n')
    linedInput.forEach { line ->
        val row = mutableListOf<List<Int>>()
        line.split(',').forEach { rowPair ->
            val rowPairIntList = mutableListOf<Int>()
            rowPair.split('-').forEach {
                rowPairIntList.add(it.toInt())
            }
            row.add(rowPairIntList.toList())
        }
        formattedInput.add(row.toList())
    }

    return formattedInput.toList()
}

fun isOverlapping(pair1: List<Int>, pair2: List<Int>, allowPartialOverlap: Boolean): Int {
    val min1 = pair1[0]
    val max1 = pair1[1]
    val min2 = pair2[0]
    val max2 = pair2[1]

    if(allowPartialOverlap)
        if((min1 in min2..max2) || (min2 in min1..max1))
            return 1

    return if((min1 <= min2 && max1 >= max2) || (min1 >= min2 && max1 <= max2))
        1
    else
        -1
}

fun countOverlaps(pairsArr: List<List<List<Int>>>, allowPartialOverlap: Boolean): Int {
    var count = 0
    pairsArr.forEach {
        if(isOverlapping(it[0], it[1], allowPartialOverlap) > 0) {
            count++
        }
    }
    return count
}

@Composable
fun AOCDay4Part1(input: List<List<List<Int>>>) {
    val part1Answer = countOverlaps(input, false)

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay4Part2(input: List<List<List<Int>>>) {
    val part2Answer = countOverlaps(input, true)

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}