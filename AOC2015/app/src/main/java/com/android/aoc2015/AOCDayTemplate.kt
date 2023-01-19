package com.android.aoc2015

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

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDayTempPart1("")
        Text(text = "|")
        AOCDayTempPart2("")
    }
}

@Composable
fun AOCDayTempPart1(input: String) {
    val part1Answer = 0

    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDayTempPart2(input: String) {
    val part2Answer = 0

    Text(text = "Part 2 = $part2Answer")
}