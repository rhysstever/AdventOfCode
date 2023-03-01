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
fun AOCDay2Preview() {
    AOCDay2()
}

@Composable
fun AOCDay2() {
    val dayNum = 2

    val formattedInput = formatStringByLineThenBySingleSpaces(day2RawInput)

    AOCDay2Part1(formattedInput)
    AOCDay2Part2(formattedInput)
}

fun formatStringByLineThenBySingleSpaces(input: String): List<List<String>> {
    val formattedInput = mutableListOf<List<String>>()
    val arrOfLines = input.split("\n")
    arrOfLines.forEach {
        if(it.isNotEmpty())
            formattedInput.add(it.split(" "))
    }
    return formattedInput.toList()
}

fun parseSign(signLetter: String): Int {
    return when(signLetter) {
        "A" -> 1
        "B" -> 2
        "C" -> 3
        "X" -> 1
        "Y" -> 2
        "Z" -> 3
        else -> -1
    }
}

fun parseMatchData(play1: Int, play2: Int): Int {
    var matchScore = play2

    matchScore += if (play1 == play2) 3
    else if (play1 == 3 && play2 == 1) 6
    else if (play1 == 1 && play2 == 3) 0
    else if (play1 > play2) 0
    else 6

    return matchScore
}

fun getMatchScores(allMatchData: List<List<String>>): Int {
    var matchScoreTotal = 0
    allMatchData.forEach {
        val opponentPlay = parseSign(it[0])
        val selfPlay = parseSign(it[1])
        matchScoreTotal += parseMatchData(opponentPlay, selfPlay)
    }

    return matchScoreTotal
}

@Composable
fun AOCDay2Part1(input: List<List<String>>) {
    val part1Answer = getMatchScores(input)

    Log.v("Answer", "Part 1 Answer: $part1Answer")
}

fun findSelfSign(opponentInput: Int, result: Int): Int {
    return when(result) {
        // Tie
        3 -> opponentInput
        // Loss
        0 -> {
            if (opponentInput == 1) 3
            else opponentInput - 1
        }
        // Win
        6 -> {
            if (opponentInput == 3) 1
            else opponentInput + 1
        }
        else -> -1
    }
}

fun parseMatchResult(matchResult: Char): Int {
    return when(matchResult) {
        'X' -> 0
        'Y' -> 3
        'Z' -> 6
        else -> -1
    }
}

fun getMatchScores2(allMatchData: List<List<String>>): Int {
    var matchScoreTotal = 0
    allMatchData.forEach {
        var opponentPlay = parseSign(it[0])
        var matchResult = parseMatchResult(it[1].toCharArray()[0])
        var selfPlay = findSelfSign(opponentPlay, matchResult)
        matchScoreTotal += parseMatchData(opponentPlay, selfPlay)
    }

    return matchScoreTotal
}

@Composable
fun AOCDay2Part2(input: List<List<String>>) {
    val part2Answer = getMatchScores2(input)

    Log.v("Answer", "Part 2 Answer: $part2Answer")
}