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
fun AOCDayTempPreview() {
    AOCDayTemp()

    val REMOVE_THIS = "CMD R to REPLACE all Temp with day num"
}

@Composable
fun AOCDayTemp() {
    val dayNum = 0

    AOCDayTempPart1("")
    AOCDayTempPart2("")
}

@Composable
fun AOCDayTempPart1(input: String) {
    val part1Answer = 0

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDayTempPart2(input: String) {
    val part2Answer = 0

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}