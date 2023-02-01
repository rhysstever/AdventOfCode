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
        AOCDay2Part1(day2RawInput)
        Text(text = "|")
        AOCDay2Part2(day2RawInput)
    }
}

fun findNumber(input: String, grid: Array<Array<Int>>, startingPos: Pair<Int, Int>): Int {
    var row = startingPos.first
    var col = startingPos.second

    input.toCharArray().forEach {
        when(it) {
            'U' -> row--
            'D' -> row++
            'R' -> col++
            'L' -> col--
        }

        row = MathUtils.clamp(row, 0, 2)
        col = MathUtils.clamp(col, 0, 2)
    }

    return grid[row][col]
}

fun findPosOfNumber(number: Int): Pair<Int, Int> {
    val row = (number - 1) / 3
    val col = (number - 1) % 3
    return Pair(row, col)
}

@Composable
fun AOCDay2Part1(input: List<String>) {
    var code = ""
    var currentPos = findPosOfNumber(5)
    var currentNum = 0

    val grid = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

    input.forEach {
        currentNum = findNumber(it, grid, currentPos)
        code += currentNum
        currentPos = findPosOfNumber(currentNum)
    }

    Text(text = "Part 1 = $code")
}

fun findPosOfChar(grid: Array<Array<Char>>, letter: Char): Pair<Int, Int> {
    for(row in 0 until grid.count()) {
        for(col in 0 until grid[row].count()) {
            if(grid[row][col] == letter)
                return Pair(row, col)
        }
    }

    Log.v("Answer", "No match found")
    return Pair(-1, -1)
}

fun findNumber2 (input: String, grid: Array<Array<Char>>, startingPos: Pair<Int, Int>): Char {
    var row = startingPos.first
    var col = startingPos.second

    input.toCharArray().forEach {
        when(it) {
            'U' -> {
                val tempRow = row - 1
                if(tempRow >= 0 && grid[tempRow][col] != '0')
                    row--
            }
            'D' -> {
                val tempRow = row + 1
                    if(tempRow < grid.size && grid[tempRow][col] != '0')
                        row++
            }
            'R' -> {
                val tempCol = col + 1
                if(tempCol < grid[row].size && grid[row][tempCol] != '0')
                    col++
            }
            'L' -> {
                val tempCol = col - 1
                if(tempCol >= 0 && grid[row][tempCol] != '0')
                    col--
            }
        }
    }

    return grid[row][col]
}

@Composable
fun AOCDay2Part2(input: List<String>) {
    var code = ""
    var currentChar = '0'

    val grid2 = arrayOf(
        arrayOf('0', '0', '1', '0', '0'),
        arrayOf('0', '2', '3', '4', '0'),
        arrayOf('5', '6', '7', '8', '9'),
        arrayOf('0', 'A', 'B', 'C', '0'),
        arrayOf('0', '0', 'D', '0', '0'),
    )

    var currentPos = findPosOfChar(grid2,'5')

    input.forEach {
        currentChar = findNumber2(it, grid2, currentPos)
        code += currentChar
        currentPos = findPosOfChar(grid2, currentChar)
    }

    Text(text = "Part 2 = $code")
}