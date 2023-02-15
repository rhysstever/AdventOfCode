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
//        AOCDay9Part1(day9RawInput)
        Text(text = "|")
        AOCDay9Part2(day9RawInput)
    }
}

fun process(input: String): Int {
    var currentString = input
    val decomposedStringList = mutableListOf<String>()

    while (currentString.contains('(')) {
        val markerStartIndex = currentString.indexOf('(')
        val stringToDupLength = currentString.substring(
            markerStartIndex + 1,
            currentString.indexOf('x')
        ).toInt()

        val stringToDupEndingIndex = currentString.indexOf(')') + 1 + stringToDupLength
        val stringToDecompose = currentString.substring(markerStartIndex, stringToDupEndingIndex)
        val decomposedString = decomposeString(stringToDecompose, false)

        // Add any string that is before the marker
        decomposedStringList.add(currentString.substring(0, markerStartIndex))
        // Add the string that needs to decomposed
        decomposedStringList.add(decomposedString)
        // Set the current string to be the remainder of the string
        currentString = currentString.substring(stringToDupEndingIndex)
    }

    // Add the remainder of the string
    decomposedStringList.add(currentString)

    var totalLength = 0
    decomposedStringList.forEach {
//        Log.v("Decompose", "$it is ${it.length} long")
        totalLength += it.length
    }
    return totalLength
}

fun process2(input: String): Int {
    return decomposeStringToLength(input, true)
}

fun decomposeString(input: String, isRecursivelyDecomposed: Boolean): String {
    if(!input.contains('('))
        return input

    val markerStartingIndex = input.indexOf('(')
    val markerEndingIndex = input.indexOf(')')
    val markerNums = input.substring(markerStartingIndex + 1, markerEndingIndex).split('x')

    val dupStringStartingIndex = markerEndingIndex + 1
    val dupStringEndingIndex = dupStringStartingIndex + markerNums[0].toInt()
    val duplicatedString = input.substring(dupStringStartingIndex, dupStringEndingIndex)

    val stringBeforeMarker = input.substring(0, markerStartingIndex)
    var repeatedString = createRepeatedString(duplicatedString, markerNums[1].toInt())
    var stringAfterMarker = input.substring(dupStringEndingIndex)

    if(isRecursivelyDecomposed) {
        val repeatedStringDecomposed = decomposeString(repeatedString, true)
        val stringAfterMarkerDecomposed = decomposeString(stringAfterMarker, true)

        repeatedString = repeatedStringDecomposed
        stringAfterMarker = stringAfterMarkerDecomposed
    }

    val returnString = stringBeforeMarker + repeatedString + stringAfterMarker
//    Log.v("Decompose: Decomposing", "$input -> $returnString")
    return returnString
}

fun decomposeStringToLength(input: String, isRecursivelyDecomposed: Boolean): Int {
    if(!input.contains('('))
        return input.length

    val markerStartingIndex = input.indexOf('(')
    val markerEndingIndex = input.indexOf(')')
    val markerNums = input.substring(markerStartingIndex + 1, markerEndingIndex).split('x')

    val dupStringStartingIndex = markerEndingIndex + 1
    val dupStringEndingIndex = dupStringStartingIndex + markerNums[0].toInt()
    val duplicatedString = input.substring(dupStringStartingIndex, dupStringEndingIndex)

    val lengthBefore = input.substring(0, markerStartingIndex).length
    var repeatedString = createRepeatedString(duplicatedString, markerNums[1].toInt())
    var stringAfterMarker = input.substring(dupStringEndingIndex)

    var repeatedStringLength = repeatedString.length
    var lengthAfter = stringAfterMarker.length

    if(isRecursivelyDecomposed) {
        repeatedStringLength = decomposeStringToLength(repeatedString, true)
        lengthAfter = decomposeStringToLength(stringAfterMarker, true)
    }

    val returnLength = lengthBefore + repeatedStringLength + lengthAfter
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
    val part1Answer = process(input)

    Log.v("Answer: Decompose", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

@Composable
fun AOCDay9Part2(input: String) {
    val part2Answer = process2(input)

    Log.v("Answer: Decompose", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}