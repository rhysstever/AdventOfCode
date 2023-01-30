package com.android.aoc2016

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AOCDay1Preview() {
    AOCDay1()
}

@Composable
fun AOCDay1() {
    val dayNum = 0

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay1Part1("")
        Text(text = "|")
        AOCDay1Part2("")
    }
}

@Composable
fun AOCDay1Part1(input: String) {
    val part1Answer = 0

    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay1Part2(input: String) {
    val part2Answer = 0

    Text(text = "Part 2 = $part2Answer")
}