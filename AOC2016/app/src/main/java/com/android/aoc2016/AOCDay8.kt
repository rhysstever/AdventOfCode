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
fun AOCDay8Preview() {
    AOCDay8()
}

@Composable
fun AOCDay8() {
    val dayNum = 8

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay8Part1(day8RawInput)
        Text(text = "|")
        AOCDay8Part2("")
    }
}

fun Array<CharArray>.copy() = map { it.clone() }.toTypedArray()

fun parseLineOfInstructions(instruction: String, startingGrid: Array<CharArray>): Array<CharArray> {
    var newGrid = startingGrid.copy()
//    Log.v("Grid", instruction)

    if(instruction.contains("rect")) {
        val size = instruction.substring("rect ".length).split('x')
        newGrid = createRect(newGrid, size[0].toInt(), size[1].toInt())
    } else if(instruction.contains("rotate")) {
        val trimmedInstruction = instruction
            .replace("rotate", "")
            .replace("column", "")
            .replace("row", "")
            .replace("x=", "")
            .replace("y=", "")
            .replace(" ", "")
        val shiftValues = trimmedInstruction.split("by")

        if(instruction.contains("column")) {
            val colNum = shiftValues[0].toInt()
            val shiftAmount = shiftValues[1].toInt()
            newGrid = shiftColumn(newGrid, colNum, shiftAmount)
        } else if(instruction.contains("row")) {
            val rowNum = shiftValues[0].toInt()
            val shiftAmount = shiftValues[1].toInt()
            newGrid = shiftRow(newGrid, rowNum, shiftAmount)
        }
    }

    Log.v("Grid", "Break")
    return newGrid
}

fun createGrid(rows: Int, columns: Int): Array<CharArray> {
    return Array(rows) { CharArray(columns) { '.' } }
}

fun createRect(grid: Array<CharArray>, width: Int, height: Int): Array<CharArray> {
    val newGrid = grid.copy()
    for(col in 0 until width) {
        for(row in 0 until height) {
            newGrid[row][col] = '#'
        }
    }

    for (row in newGrid) {
        Log.v("Grid: Create", row.contentToString())
    }
    return newGrid
}

fun shiftRow(grid: Array<CharArray>, rowNum: Int, shiftAmount: Int): Array<CharArray> {
    val newGrid = grid.copy()

    for (currentCol in 0 until grid[rowNum].size) {
        val charToShift = grid[rowNum][currentCol]
        val shiftedCol = (currentCol + shiftAmount) % grid[rowNum].size
        newGrid[rowNum][shiftedCol] = charToShift
    }

    for (row in newGrid) {
        Log.v("Grid: Row Shift", row.contentToString())
    }
    return newGrid
}

fun shiftColumn(grid: Array<CharArray>, colNum: Int, shiftAmount: Int): Array<CharArray> {
    val newGrid = grid.copy()

    for (currentRow in 0 until grid.size) {
        val charToShift = grid[currentRow][colNum]
        val shiftedRow = (currentRow + shiftAmount) % grid.size
        newGrid[shiftedRow][colNum] = charToShift
    }

    for (row in newGrid) {
        Log.v("Grid: Col Shift", row.contentToString())
    }
    return newGrid
}

fun countPixels(grid: Array<CharArray>): Int {
    var totalPixels = 0
    for (row in grid) {
        for (character in row) {
            if(character == '#')
                totalPixels++
        }
    }
    return totalPixels
}

@Composable
fun AOCDay8Part1(input: List<String>) {
    var grid = createGrid(6, 50)

    input.forEach {
        grid = parseLineOfInstructions(it, grid)
    }
    val part1Answer = countPixels(grid)

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay8Part2(input: String) {
    val part2Answer = 0

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}