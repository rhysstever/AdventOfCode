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
fun AOCDay10Preview() {
    AOCDay10()
}

@Composable
fun AOCDay10() {
    val dayNum = 0

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay10Part1(day10RawInput)
        Text(text = "|")
        AOCDay10Part2("")
    }
}

fun addChipsToBots(input: List<String>): MutableMap<Int, MutableList<Int>> {
    val bots = mutableMapOf<Int, MutableList<Int>>()

    input.forEach {
        if(it.contains("value")) {
            val chipValueIndexStart = it.indexOf("value ") + "value ".length
            val chipValueIndexEnd = it.indexOf(" goes")
            val chipValue = it.substring(chipValueIndexStart, chipValueIndexEnd).toInt()

            val botNum = it[it.indexOf("bot ") + "bot ".length].toString().toInt()

//            Log.v("Day10: Add Chip", "$it -> chip $chipValue to bot $botNum")
            if(bots.contains(botNum)) {
                bots[botNum]!!.add(chipValue)
            } else {
                val newValue = mutableListOf(chipValue)
                bots[botNum] = newValue
            }
            Log.v("Day10: Add Chip", bots.toString())
        }
    }

    return bots
}

@Composable
fun AOCDay10Part1(input: List<String>) {
    val part1Answer = 0

    val bots = addChipsToBots(input)

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay10Part2(input: String) {
    val part2Answer = 0

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}