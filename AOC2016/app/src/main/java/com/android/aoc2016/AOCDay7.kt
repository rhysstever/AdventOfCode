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
        AOCDay7Part1(day7TestInput)
        Text(text = "|")
        AOCDay7Part2("")
    }
}

fun doesSupportTLS(ipAddress: String): Boolean {
    val strings = ipAddress.replace("[", "]").split("]")
    return (hasPairAndReverse(strings[0])
                || hasPairAndReverse(strings[2]))
            && !hasPairAndReverse(strings[1])
}

fun hasPairAndReverse(input: String): Boolean {
    for(startOfPair in 0 until input.length - 1) {
        // Get pair
        val pair = input.substring(startOfPair, startOfPair + 2)
        // Check pair
        if(pair != pair.reversed()) {
            if(input.indexOf(pair.reversed(), startOfPair + 2) != -1) {
//                Log.v("Answer: P&R", "$input true")
                return true
            }
        }
    }

//    Log.v("Answer: P&R", "$input false")
    return false
}

@Composable
fun AOCDay7Part1(input: List<String>) {
    var part1Answer = 0

    input.forEach {
        if(doesSupportTLS(it))
            part1Answer++
    }

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay7Part2(input: String) {
    val part2Answer = 0

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}