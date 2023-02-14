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
fun AOCDay7Preview() {
    AOCDay7()
}

@Composable
fun AOCDay7() {
    val dayNum = 7

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay7Part1("")
        Text(text = "|")
        AOCDay7Part2("")
    }
}

@Composable
fun AOCDay7Part1(input: String) {
    val part1Answer = 0

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay7Part2(input: String) {
    val part2Answer = 0

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}