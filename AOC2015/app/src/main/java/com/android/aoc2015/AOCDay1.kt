package com.android.aoc2015

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AOCDay1Preview() {
    AOCDay1()
}

@Composable
fun AOCDay1() {
    val dayNum = 1

    val formattedInput = day1RawInput.toCharArray()

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay1Part1(formattedInput)
        Text(text = "|")
        AOCDay1Part2(formattedInput)
    }
}

@Composable
fun AOCDay1Part1(input: CharArray) {
    var currentFloor = 0

    input.forEach {
        when (it) {
            '(' -> currentFloor++
            ')' -> currentFloor--
            else -> Log.v("Testing", "Error! Unexpected case: $it")
        }
    }

    Text(text = "Part 1 = $currentFloor")
}

@Composable
fun AOCDay1Part2(input: CharArray) {
    var currentFloor = 0
    var basementIndex = -1

    for (i in input.indices) {
        var element = input[i]
        when (element) {
            '(' -> currentFloor++
            ')' -> currentFloor--
            else -> Log.v("Testing", "Error! Unexpected case: $element")
        }

        if(currentFloor == -1) {
            basementIndex = i + 1
            break
        }
    }

    Text(text = "Part 2 = $basementIndex")
}