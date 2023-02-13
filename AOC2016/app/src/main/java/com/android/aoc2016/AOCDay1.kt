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
        AOCDay1Part2(day1RawInput)
    }
}

fun walkInstructions(input: List<String>): Int {
    var pos = Pair(0, 0)
    var currentDirectionChar = 'U'

    input.forEach {
        val turnChar = it.toCharArray()[0]
        currentDirectionChar = turn(currentDirectionChar, turnChar)

        val distance = it.substring(1).toInt()
        pos = addMove(pos, findMove(Pair(currentDirectionChar, distance)))
    }

    return totalBlocksAway(pos)
}

fun turn(currentDirectionChar: Char, turnChar: Char): Char {
    val directionCharsList = listOf('U', 'R', 'D', 'L')

    var currentIndex = directionCharsList.indexOf(currentDirectionChar)
    currentIndex += when(turnChar) {
        'R' -> 1
        'L' -> -1
        else -> 0
    }

    // Clamp to directions list
    if(currentIndex < 0)
        currentIndex = directionCharsList.count() - 1
    else if(currentIndex >= directionCharsList.count())
        currentIndex = 0

    return directionCharsList[currentIndex]
}

fun findMove(instruction: Pair<Char, Int>): Pair<Int, Int> {
    return when(instruction.first) {
        'U' -> Pair(instruction.second, 0)
        'R' -> Pair(0, instruction.second)
        'D' -> Pair(-instruction.second, 0)
        'L' -> Pair(0, -instruction.second)
        else -> Pair(0, 0)
    }
}

fun addMove(currentPos: Pair<Int, Int>, move: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(
        currentPos.first + move.first,
        currentPos.second + move.second
    )
}

fun totalBlocksAway(distanceSums: Pair<Int, Int>): Int {
    return abs(distanceSums.first) + abs(distanceSums.second)
}

@Composable
fun AOCDay1Part1(input: List<String>) {
    val totalBlocksAwayDist = walkInstructions(input)

    Log.v("Answer", "Part 1 Answer: $totalBlocksAwayDist")
    Text(text = "Part 1 = $totalBlocksAwayDist")
}

fun walkInstructions2(input: List<String>): Int {
    var pos = Pair(0, 0)
    var currentDirectionChar = 'U'
    val pastLocations = mutableListOf<Pair<Int, Int>>()

    input.forEach {
        val turnChar = it.toCharArray()[0]
        currentDirectionChar = turn(currentDirectionChar, turnChar)

        val distance = it.substring(1).toInt()

        for(step in 1..distance) {
            pos = addMove(pos, findMove(Pair(currentDirectionChar, 1)))
//            Log.v("AOC Answer", pos.toString())

            if(pastLocations.contains(pos))
                return totalBlocksAway(pos)
            else
                pastLocations.add(pos)
        }
    }

    Log.v("AOC Answer", "Error! No past location visited twice")
    return totalBlocksAway(pos)
}

@Composable
fun AOCDay1Part2(input: List<String>) {
    val totalBlocksAwayDist = walkInstructions2(input)

    Log.v("Answer", "Part 2 Answer: $totalBlocksAwayDist")
    Text(text = "Part 2 = $totalBlocksAwayDist")
}