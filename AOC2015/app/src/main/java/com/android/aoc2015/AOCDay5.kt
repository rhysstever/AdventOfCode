package com.android.aoc2015

import android.util.Log
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
        AOCDay5Part1(day5RawInput)
        Text(text = "|")
        AOCDay5Part2(day5RawInput)
    }
}

fun IsNiceStr(str: String): Boolean {
    val charArr = str.toCharArray()
    val vowelsInArr = mutableListOf<Char>()
    var hasDoubleLetter = false

    for(i in charArr.indices) {
        when(charArr[i]) {
            'a' -> vowelsInArr.add(charArr[i])
            'e' -> vowelsInArr.add(charArr[i])
            'i' -> vowelsInArr.add(charArr[i])
            'o' -> vowelsInArr.add(charArr[i])
            'u' -> vowelsInArr.add(charArr[i])
            'b' -> {
                if(i > 0 && charArr[i - 1] == 'a') {
                    return false
                }
            }
            'd' -> {
                if(i > 0 && charArr[i - 1] == 'c') {
                    return false
                }
            }
            'q' -> {
                if(i > 0 && charArr[i - 1] == 'p') {
                    return false
                }
            }
            'y' -> {
                if(i > 0 && charArr[i - 1] == 'x') {
                    return false
                }
            }
        }

        if(!hasDoubleLetter) {
            if(i > 0 && charArr[i - 1] == charArr[i]) {
                hasDoubleLetter = true
            }
        }
    }

    return hasDoubleLetter && vowelsInArr.count() >= 3
}

@Composable
fun AOCDay5Part1(input: List<String>) {
    var niceStrCount = 0

    input.forEach {
        if(IsNiceStr(it))
            niceStrCount++
    }

    Text(text = "Part 1 = $niceStrCount")
}

fun IsNiceStr2(str: String, num: Int): Boolean {
    val charArr = str.toCharArray()
    var hasDoublePair = false
    var hasRepeatingLetter = false

    for(i in charArr.indices) {
        if(!hasDoublePair) {
            if(i > 0 && i < charArr.count() - 2) {
                val subStr = str.substring(i - 1, i + 1)
                val index = str.indexOf(subStr, i + 1)
                if(index != -1) {
                    hasDoublePair = true
                }
            }
        }

        if(!hasRepeatingLetter) {
            if(i > 1) {
                if (charArr[i - 2] == charArr[i]) {
                    hasRepeatingLetter = true
                }
            }
        }
    }

    return hasDoublePair && hasRepeatingLetter
}

@Composable
fun AOCDay5Part2(input: List<String>) {
    var niceStrCount = 0

    input.forEach {
        if(IsNiceStr2(it, niceStrCount)) {
            niceStrCount++
        }
    }

    Text(text = "Part 2 = $niceStrCount")
}