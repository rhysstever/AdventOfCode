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
fun AOCDay25Preview() {
    AOCDay25()
}

@Composable
fun AOCDay25() {
    val dayNum = 25

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay25Part1(day25RawInput)
        Text(text = "|")
        AOCDay25Part2("")
    }
}

fun convertSNAFUToDecimal(snafuNumGoal: String): Int {
    var currentDecimal = 0
    var currentSNAFU = "0"

    while (currentSNAFU != snafuNumGoal) {
        currentDecimal++
        currentSNAFU = incrementString(currentSNAFU)
    }

    return currentDecimal
}

fun getNextSymbol(currentSymbol: Char): String {
//    Log.v("Day25: Next Symbol", "$currentSymbol")
    return when(currentSymbol) {
        '=' -> "-"
        '-' -> "0"
        '0' -> "1"
        '1' -> "2"
        '2' -> "="
        else -> "1"
    }
}

fun incrementString(snafuString: String): String {
    val lastChar = snafuString.last()
    val newChar = getNextSymbol(lastChar)

    return if(newChar == "=") {
        if(snafuString.dropLast(1).length == 0)
            "1="
        else
            incrementString(snafuString.dropLast(1)) + newChar
    }
    else
        snafuString.dropLast(1) + newChar
}

fun convertDecimalToSNAFU(decimalNumGoal: Int): String {
    var currentDecimal = 0
    var currentSNAFU = "0"

    while (currentDecimal != decimalNumGoal) {
        currentDecimal++
        currentSNAFU = incrementString(currentSNAFU)
    }

    return currentSNAFU
}

@Composable
fun AOCDay25Part1(input: List<String>) {
    var total = 0
    input.forEach {
        val decimal = convertSNAFUToDecimal(it)
        Log.v("Day25", "$it $decimal")
        total += decimal
    }
    val part1Answer = convertDecimalToSNAFU(total)

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay25Part2(input: String) {
    val part2Answer = 0

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}