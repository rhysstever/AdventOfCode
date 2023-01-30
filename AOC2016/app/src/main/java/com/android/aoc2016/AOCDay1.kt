package com.android.aoc2016

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@Preview
@Composable
fun AOCDay1Preview() {
    AOCDay1()
}

@Composable
fun AOCDay1() {
    val dayNum = 1

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay1Part1(day1RawInput)
        Text(text = "|")
        AOCDay1Part2("")
    }
}

fun processDirection(currentMovement: MutableList<Int>, currentDirectionIndex: Int, direction: String): Int {
    var newCurrentDirectionIndex = currentDirectionIndex

    newCurrentDirectionIndex += when(direction.toCharArray()[0]) {
        'L' -> -1
        'R' -> +1
        else -> 0
    }

    if(newCurrentDirectionIndex < 0)
        newCurrentDirectionIndex = currentMovement.count() - 1
    else if(newCurrentDirectionIndex >= currentMovement.count())
        newCurrentDirectionIndex = 0

    val walkAmount = direction.substring(1).toInt()
    currentMovement[newCurrentDirectionIndex] += walkAmount

    return newCurrentDirectionIndex
}

@Composable
fun AOCDay1Part1(input: List<String>) {
    var directions = mutableListOf(0, 0, 0, 0)
    var directionIndex = 0

    input.forEach {
        directionIndex = processDirection(directions, directionIndex, it)
//        Log.v("AOC Answer", "$it | ${directions.toString()}")
    }

    val totalBlocksAway = abs(directions[0] - directions[2]) + abs(directions[1] - directions[3])

    Text(text = "Part 1 = $totalBlocksAway")
}

@Composable
fun AOCDay1Part2(input: String) {
    val part2Answer = 0

    Text(text = "Part 2 = $part2Answer")
}