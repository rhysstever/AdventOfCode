package com.android.aoc2016

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AOCDay6Preview() {
    AOCDay6()
}

@Composable
fun AOCDay6() {
    val dayNum = 6

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay6Part1(day6RawInput)
        Text(text = "|")
        AOCDay6Part2(day6RawInput)
    }
}

fun createColumnString(input: List<String>, columnIndex: Int): String {
    var str = ""

    input.forEach {
        str += it[columnIndex]
    }

    return str
}

@Composable
fun AOCDay6Part1(input: List<String>) {
    var part1Answer = ""

    var columnStrings = mutableListOf<String>()
    for (i in 0 until input[0].length) {
        columnStrings.add(createColumnString(input, i))
    }

    columnStrings.forEach {
        part1Answer += findMostCommonChar(it)
    }

    Text(text = "Part 1 = $part1Answer")
}

fun findLeastCommonChar(string: String): Char {
    var mostCommonChar = 'a'
    var mostCommonCharCount = Integer.MAX_VALUE

    // Sort string
    val charArr = string.toCharArray()
    charArr.sort()

    charArr.forEach {
        if(!it.isDigit()) {
            val count = countOccurrences(string, it)
            if(count < mostCommonCharCount) {
                mostCommonChar = it
                mostCommonCharCount = count
            }
        }
    }

    return mostCommonChar
}

@Composable
fun AOCDay6Part2(input: List<String>) {
    var part2Answer = ""

    var columnStrings = mutableListOf<String>()
    for (i in 0 until input[0].length) {
        columnStrings.add(createColumnString(input, i))
    }

    columnStrings.forEach {
        part2Answer += findLeastCommonChar(it)
    }

    Text(text = "Part 2 = $part2Answer")
}