package com.android.aoc2015

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import kotlin.math.min

@Preview
@Composable
fun AOCDay2Preview() {
    AOCDay2()
}

@Composable
fun AOCDay2() {
    val dayNum = 2

    var formattedInput = mutableListOf<List<Int>>()
    day2RawInput.forEach {
        var inputLine = it.split("x")
        val inputLineInt = inputLine.map { it.toInt() }
        formattedInput.add(inputLineInt)
    }

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay2Part1(formattedInput)
        Text(text = "|")
        AOCDay2Part2(formattedInput)
    }
}

fun findMinimum(elements: List<Int>): Int {
    var currentMin = Int.MAX_VALUE
    elements.forEach {
        if(it < currentMin)
            currentMin = it
    }
    return currentMin
}

@Composable
fun AOCDay2Part1(input: List<List<Int>>) {
    var totalWrappingPaper = 0

    input.forEach {
        val side1Area = it[0] * it[1]
        val side2Area = it[1] * it[2]
        val side3Area = it[2] * it[0]
        val minArea = findMinimum(listOf(side1Area, side2Area, side3Area))
        totalWrappingPaper += 2 * side1Area + 2 * side2Area + 2 * side3Area + minArea
    }

    Text(text = "Part 1 = $totalWrappingPaper")
}

@Composable
fun AOCDay2Part2(input: List<List<Int>>) {
    var totalRibbon = 0

    input.forEach {
        val side1Perimeter = 2 * it[0] + 2 * it[1]
        val side2Perimeter = 2 * it[1] + 2 * it[2]
        val side3Perimeter = 2 * it[2] + 2 * it[0]
        val volume = it[0] * it[1] * it[2]
        val minPerimeter = findMinimum(listOf(side1Perimeter, side2Perimeter, side3Perimeter))
        totalRibbon += volume + minPerimeter
    }

    Text(text = "Part 2 = $totalRibbon")
}