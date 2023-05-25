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

fun UpdateIntPair(currentPair: Pair<Int, Int>, direction: Char): Pair<Int, Int> {
    return when(direction) {
        '>' -> Pair(currentPair.first + 1, currentPair.second)
        '<' -> Pair(currentPair.first - 1, currentPair.second)
        '^' -> Pair(currentPair.first, currentPair.second + 1)
        'v' -> Pair(currentPair.first, currentPair.second - 1)
        else -> currentPair
    }
}

@Composable
fun AOCDay3Part1(input: String) {
    var currentPair = Pair(0, 0)
    val visitedHousesList = mutableListOf<Pair<Int, Int>>()
    val directionArr = input.split("")

    directionArr.forEach {
        val char = it.toCharArray()
        if(char.isNotEmpty())
            currentPair = UpdateIntPair(currentPair, char[0])

        if(!visitedHousesList.contains(currentPair))
            visitedHousesList.add(currentPair)
    }

    Text(text = "Part 1 = ${visitedHousesList.count()}")
    Log.v("Answer: Day 3", "Part 1 = ${visitedHousesList.count()}")
}

@Composable
fun AOCDay3Part2(input: String) {
    var currentPairSanta = Pair(0, 0)
    var currentPairRoboSanta = Pair(0, 0)
    val visitedHousesList = mutableListOf<Pair<Int, Int>>()
    visitedHousesList.add(currentPairSanta)
    val directionArr = input.split("")

    for(i in directionArr.indices) {
        val char = directionArr[i].toCharArray()

        if(i % 2 == 0) {
            if(char.isNotEmpty()) {
                currentPairSanta = UpdateIntPair(currentPairSanta, char[0])
                if(!visitedHousesList.contains(currentPairSanta))
                    visitedHousesList.add(currentPairSanta)
            }
        } else {
            if(char.isNotEmpty()) {
                currentPairRoboSanta = UpdateIntPair(currentPairRoboSanta, char[0])
                if(!visitedHousesList.contains(currentPairRoboSanta))
                    visitedHousesList.add(currentPairRoboSanta)
            }
        }
    }

    Text(text = "Part 2 = ${visitedHousesList.count()}")
    Log.v("Answer: Day 3", "Part 2 = ${visitedHousesList.count()}")
}