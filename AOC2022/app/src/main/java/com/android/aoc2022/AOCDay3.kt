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
fun AOCDay3Preview() {
    AOCDay3()
}

@Composable
fun AOCDay3() {
    val dayNum = 3

    AOCDay3Part1(day3RawInput)
    AOCDay3Part2(day3RawInput)
}

fun findSimilarChars(str1: String, str2: String): List<Char> {
    val similarChars = mutableListOf<Char>()

    str1.toCharArray().forEach {
        if(!similarChars.contains(it) && str2.contains(it))
            similarChars.add(it)
    }

    return similarChars
}

fun convertLetterToNumber(character: Char): Int {
    var num = character.code
    num -= if(character == character.lowercaseChar())
        96
    else
        38

    return num
}

fun getPrioritySum(input: List<String>): Int {
    var totalPrio = 0
    input.forEach {
        val compartmentLength = it.length / 2
        val str1 = it.substring(0 until compartmentLength)
        val str2 = it.substring(compartmentLength)

        val similarChars = findSimilarChars(str1, str2)

        similarChars.forEach { char ->
            val prio = convertLetterToNumber(char)
            totalPrio += prio
        }
    }
    return totalPrio
}

@Composable
fun AOCDay3Part1(input: List<String>) {
    val part1Answer = getPrioritySum(input)

    Log.v("Answer", "Part 1 Answer: $part1Answer")
    Text(text = "Part 1 = $part1Answer")
}

fun findSimilarChars(strings: List<String>): List<Char> {
    val similarChars = mutableListOf<Char>()

    strings[0].toCharArray().forEach {
        if(isCharContainedInList(it, strings) && !similarChars.contains(it))
            similarChars.add(it)
    }

    return similarChars
}

fun isCharContainedInList(char: Char, stringList: List<String>): Boolean {
    stringList.forEach {
        if(!it.contains(char))
            return false
    }
    return true
}

fun getPrioritySum2(input: List<String>): Int {
    var totalPrio = 0
    var totalSimilarChars = ""

    for (i in 0..input.size - 2 step 3) {
        val strSlice = input.slice(i..i + 2)
        val similarChars = findSimilarChars(strSlice)

        similarChars.forEach { char ->
            totalSimilarChars += char
            totalPrio += convertLetterToNumber(char)
        }
    }

    return totalPrio
}

@Composable
fun AOCDay3Part2(input: List<String>) {
    val part2Answer = getPrioritySum2(input)

    Log.v("Answer", "Part 2 Answer: $part2Answer")
    Text(text = "Part 2 = $part2Answer")
}