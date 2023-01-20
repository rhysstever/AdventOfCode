package com.android.aoc2015

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
    val dayNum = 0

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay5Part1("")
        Text(text = "|")
        AOCDay5Part2("")
    }
}

fun IsNiceStr(str: String): Boolean {
    if(str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy"))
        return false

    val charArr = str.toCharArray()

    var vowelsInArr = mutableListOf<Char>()

    for(i in charArr.indices) {
        when(charArr[i]) {
            'a' -> vowelsInArr.add(charArr[i])
            'e' -> vowelsInArr.add(charArr[i])
            'i' -> vowelsInArr.add(charArr[i])
            'o' -> vowelsInArr.add(charArr[i])
            'u' -> vowelsInArr.add(charArr[i])
            'b' -> {

            }
        }
    }

    return true
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