package com.android.aoc2016

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
    val dayNum = 5

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay5Part1("")
        Text(text = "|")
        AOCDay5Part2("")
    }
}

@Composable
fun AOCDay5Part1(input: String) {
    val part1Answer = 0

    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay5Part2(input: String) {
    val part2Answer = 0

    Text(text = "Part 2 = $part2Answer")
}