package com.android.aoc2016

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AOCDay3Preview() {
    AOCDay3()
}

@Composable
fun AOCDay3() {
    val dayNum = 3

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay3Part1(day3RawInput)
        Text(text = "|")
        AOCDay3Part2(day3RawInput)
    }
}

fun canBeATriangle(side1: Int, side2: Int, side3: Int): Boolean {
    return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1
}

@Composable
fun AOCDay3Part1(input: List<String>) {
    var trianglesCount = 0

    input.forEach {
        val strSplit = it.split(" ")
        val side1 = strSplit[0].toInt()
        val side2 = strSplit[1].toInt()
        val side3 = strSplit[2].toInt()

        if(canBeATriangle(side1, side2, side3))
            trianglesCount++
    }

    Text(text = "Part 1 = $trianglesCount")
}

@Composable
fun AOCDay3Part2(input: List<String>) {
    var trianglesCount = 0

    for(row in 1 until input.size - 1 step 3) {
        for(i in 0..2) {
            val side1 = input[row - 1].split(" ")[i].toInt()
            val side2 = input[row].split(" ")[i].toInt()
            val side3 = input[row + 1].split(" ")[i].toInt()

            if(canBeATriangle(side1, side2, side3))
                trianglesCount++
        }
    }

    Text(text = "Part 2 = $trianglesCount")
}