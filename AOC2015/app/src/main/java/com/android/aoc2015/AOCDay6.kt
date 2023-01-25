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
fun AOCDay6Preview() {
    AOCDay6()
}

@Composable
fun AOCDay6() {
    val dayNum = 6

    val grid = Array(1000) { BooleanArray(1000) }
    val grid2 = Array(1000) { IntArray(1000) }

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay6Part1(grid, day6RawInput)
        Text(text = "|")
        AOCDay6Part2(grid2, day6RawInput)
    }
}

enum class InstructionType {
    On, Off, Toggle, None
}

fun followInstructions(grid: Array<BooleanArray>, instructionType: InstructionType, startingCoord: Pair<Int, Int>, endingCoord: Pair<Int, Int>) {
    for(i in startingCoord.first until endingCoord.first + 1) {
        for(j in startingCoord.second until endingCoord.second + 1) {
            grid[i][j] = when(instructionType) {
                InstructionType.On -> true
                InstructionType.Off -> false
                InstructionType.Toggle -> !grid[i][j]
                else -> grid[i][j]
            }
        }
    }
}

fun countLightsOn(grid: Array<BooleanArray>): Int {
    var counter = 0
    grid.forEach { row ->
        row.forEach {
            if(it)
                counter++
        }
    }
    return counter
}

@Composable
fun AOCDay6Part1(grid: Array<BooleanArray>, input: List<String>) {
    input.forEach {
        val parsedInstruction = it.split(" ")
        val instructionType = when(parsedInstruction[0]) {
            "on" -> InstructionType.On
            "off" -> InstructionType.Off
            "toggle" -> InstructionType.Toggle
            else -> InstructionType.None
        }
        val startingCoord = Pair(
            parsedInstruction[1].split(",")[0].toInt(),
            parsedInstruction[1].split(",")[1].toInt()
        )
        val endingCoord = Pair(
            parsedInstruction[2].split(",")[0].toInt(),
            parsedInstruction[2].split(",")[1].toInt()
        )

        followInstructions(
            grid,
            instructionType,
            startingCoord,
            endingCoord
        )
    }

    Text(text = "Part 1 = ${countLightsOn(grid)}")
}

fun followInstructions2(grid: Array<IntArray>, instructionType: InstructionType, startingCoord: Pair<Int, Int>, endingCoord: Pair<Int, Int>) {
    for(i in startingCoord.first until endingCoord.first + 1) {
        for(j in startingCoord.second until endingCoord.second + 1) {
            grid[i][j] += when(instructionType) {
                InstructionType.On -> 1
                InstructionType.Off -> -1
                InstructionType.Toggle -> 2
                else -> 0
            }

            if(grid[i][j] < 0)
                grid[i][j] = 0
        }
    }
}

fun totalLightBrightness(grid: Array<IntArray>): Int {
    var total = 0
    grid.forEach { row ->
        row.forEach {
            total += it
        }
    }
    return total
}

@Composable
fun AOCDay6Part2(grid: Array<IntArray>, input: List<String>) {
    input.forEach {
        val parsedInstruction = it.split(" ")
        val instructionType = when(parsedInstruction[0]) {
            "on" -> InstructionType.On
            "off" -> InstructionType.Off
            "toggle" -> InstructionType.Toggle
            else -> InstructionType.None
        }
        val startingCoord = Pair(
            parsedInstruction[1].split(",")[0].toInt(),
            parsedInstruction[1].split(",")[1].toInt()
        )
        val endingCoord = Pair(
            parsedInstruction[2].split(",")[0].toInt(),
            parsedInstruction[2].split(",")[1].toInt()
        )

        followInstructions2(
            grid,
            instructionType,
            startingCoord,
            endingCoord
        )
    }

    Text(text = "Part 2 = ${totalLightBrightness(grid)}")
}