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
fun AOCDay5Preview() {
    AOCDay5()
}

@Composable
fun AOCDay5() {
    val dayNum = 0

    val formattedCommands = formatCommands(commands)

    AOCDay5Part1(formattedCommands)
    AOCDay5Part2("")
}

fun formatCommands(commands: String): List<List<Int>> {
    val commandsF = mutableListOf<List<Int>>()
    commands.split("\n").forEach { commandLine ->
        val commandLineF = commandLine
            .replace(Regex("[a-zA-Z]"), "")
            .drop(1)
            .split("  ")
        val commandLineIntF = mutableListOf<Int>()
        commandLineF.forEach {
            commandLineIntF.add(it.toInt())
        }

        commandsF.add(commandLineIntF.toList())
    }
    return commandsF.toList()
}

fun moveCrate(layout: List<List<Int>>, startingIndex: Int, endingIndex: Int): List<List<Int>> {
    val newLayout = mutableListOf<MutableList<Int>>()
    layout.forEach {
        val tempList = mutableListOf<Int>()
        it.forEach { num ->
            tempList.add(num)
        }
        newLayout.add(tempList)
    }
    
    val removedCrate = newLayout[startingIndex].last()
    newLayout[startingIndex] = newLayout[startingIndex].dropLast(1)

    layout[endingIndex]
    return layout
}

fun issueCommands(layout: List<List<Int>>, commands: List<List<Int>>): List<List<String>> {
    var layout1 = layout

    commands.forEach { command ->
        val moveCount = command[0]
        val startingIndex = command[1]
        val endingIndex = command[2]

        for(i in 0 until moveCount) {
            layout1 = moveCrate(layout1, startingIndex, endingIndex)
        }
    }
    return layout1
}

fun getTopCrates(rowsOfCrates: List<List<String>>): String {
    var returnStr = ""
    rowsOfCrates.forEach { row ->
        val lastIndex = row.length - 1
        returnStr += row[lastIndex]
    }
    return returnStr
}

@Composable
fun AOCDay5Part1(input: List<List<Int>>, commands: List<List<Int>>) {
    val part1Answer = getTopCrates(issueCommands(input, commands))

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay5Part2(input: String) {
    val part2Answer = 0

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}