package com.android.aoc2016

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.math.MathUtils

@Preview
@Composable
fun AOCDay2Preview() {
    AOCDay2()
}

@Composable
fun AOCDay2() {
    val dayNum = 2

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay2Part1(day2TestInput)
        Text(text = "|")
        AOCDay2Part2("")
    }
}

fun findNumber(input: String, startingPos: Pair<Int, Int>): Int {
    val grid = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

    var row = startingPos.first
    var col = startingPos.second

    input.toCharArray().forEach {
        Log.v("AOC Answer", "$it")
        when(it) {
            'U' -> row--
            'D' -> row++
            'R' -> col++
            'L' -> col--
        }

        row = MathUtils.clamp(row, 1, 3)
        col = MathUtils.clamp(col, 1, 3)
    }

    return grid[row][col]
}

fun findPosOfNumber(number: Int): Pair<Int, Int> {
    val row = number / 3
    val col = (number - 1) % 3
    return Pair(row, col - 1)
}

@Composable
fun AOCDay2Part1(input: List<String>) {
    var code = ""

    val grid = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

//    input.forEach {
//        Log.v("AOC Answer", code)
//        code += findNumber(it)
//    }

    for(index in 1..9) {
        val startingNum = index
        Log.v("AOC Answer", "$startingNum")
        val answer = findPosOfNumber(startingNum)
        Log.v("AOC Answer", "$answer")
        val endingNum = grid[answer.first][answer.second]
        Log.v("AOC Answer", "$endingNum")
    }

//    for(row in 0 until grid.count()) {
//        for(column in 0 until grid[row].count()) {
//            Log.v("AOC Answer", "$row $column")
//        }
//    }


    Text(text = "Part 1 = ")
}

@Composable
fun AOCDay2Part2(input: String) {
    val part2Answer = 0

    Text(text = "Part 2 = $part2Answer")
}