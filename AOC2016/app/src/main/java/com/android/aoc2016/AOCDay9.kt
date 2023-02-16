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
fun AOCDay9Preview() {
    AOCDay9()
}

@Composable
fun AOCDay9() {
    val dayNum = 9

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay9Part1(day9RawInput)
        Text(text = "|")
        AOCDay9Part2(day9RawInput)
    }
}

fun decomposeStringToLength(input: String, isRecursing: Boolean): Long {
    if(!input.contains('('))
        return input.length.toLong()

    val markerStartingIndex = input.indexOf('(')
    val markerEndingIndex = input.indexOf(')')
    val markerNums = input.substring(
        markerStartingIndex + 1,
        markerEndingIndex
    ).split('x')

    val dupStringStartingIndex = markerEndingIndex + 1
    val dupStringEndingIndex = dupStringStartingIndex + markerNums[0].toInt()
    val duplicatedString = input.substring(
        dupStringStartingIndex,
        dupStringEndingIndex
    )

    val lengthBefore = input.substring(0, markerStartingIndex).length

    val repeatedString = createRepeatedString(duplicatedString, markerNums[1].toInt())
    val stringAfterMarker = input.substring(dupStringEndingIndex)

    var repeatedStringLength = repeatedString.length.toLong()
    if(isRecursing)
        repeatedStringLength = decomposeStringToLength(repeatedString, true)

    val lengthAfter = decomposeStringToLength(stringAfterMarker, isRecursing)

    val returnLength = lengthBefore + repeatedStringLength + lengthAfter
    if(returnLength > 100000000)
        Log.v("Decompose: Decomposing", "Length is $returnLength")
    return returnLength
}

fun createRepeatedString(stringToRepeat: String, repeatCount: Int): String {
    var finalString = ""
    for(i in 0 until repeatCount) {
        finalString += stringToRepeat
    }
    return finalString
}

@Composable
fun AOCDay9Part1(input: String) {
    val part1Answer = decomposeStringToLength(input, false)

    Log.v("Answer: Decompose", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay9Part2(input: String) {
    val part2Answer = decomposeStringToLength(input, true)

    Log.v("Answer: Decompose", "Part 2 Answer: $part2Answer")
//    Text(text = "Part 2 = $part2Answer")
}