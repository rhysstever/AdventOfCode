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
fun AOCDay4Preview() {
    AOCDay4()
}

@Composable
fun AOCDay4() {
    val dayNum = 4

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay4Part1(day4RawInput)
        Text(text = "|")
        AOCDay4Part2(day4RawInput)
    }
}

fun isValidRoom(name: String, checkSum: String): Boolean {
    val mostCommonChars = findCommonChars(name, 5)
//    Log.v("Answer", "$name $mostCommonChars $checkSum ${mostCommonChars == checkSum}")

    return mostCommonChars == checkSum
}

fun findCommonChars(string: String, length: Int): String {
    var mostCommonStr = ""
    var currentStr = string

    do {
        val currentCommonChar = findMostCommonChar(currentStr)
        currentStr = currentStr.replace(currentCommonChar.toString(), "")
        mostCommonStr += currentCommonChar
    } while (mostCommonStr.length < length)

    return mostCommonStr
}

fun findMostCommonChar(string: String): Char {
    var mostCommonChar = 'a'
    var mostCommonCharCount = -1

    // Sort string
    val charArr = string.toCharArray()
    charArr.sort()

    charArr.forEach {
        if(!it.isDigit()) {
            val count = countOccurrences(string, it)
            if(count > mostCommonCharCount) {
                mostCommonChar = it
                mostCommonCharCount = count
            }
        }
    }

    return mostCommonChar
}

fun countOccurrences(s: String, ch: Char): Int {
    return s.filter { it == ch }.count()
}

@Composable
fun AOCDay4Part1(input: List<String>) {
    var sectorIDSum = 0

    input.forEach {
        val name = it.split('[')[0].replace("-", "").dropLast(3)
        val sectorID = it.split('[')[0].split('-').last().toInt()
        val checkSum = it.split('[')[1].dropLast(1)
//        Log.v("Answer", "$name $sectorID $checkSum")

        if(isValidRoom(name, checkSum))
            sectorIDSum += sectorID
    }

    Text(text = "Part 1 = $sectorIDSum")
}

fun decryptName(encryptedName: String, sectorID: Int): String {
    var cypher = "abcdefghijklmnopqrstuvwxyz".split("")
    cypher = cypher.filter { it != null && !it.isBlank() }

    var decryptedName = ""
    for (index in 0 until encryptedName.toCharArray().size) {
        if(encryptedName[index] == '-') {
            decryptedName += ' '
        } else {
            val char = encryptedName[index]
            val charIndex = cypher.indexOf(char.toString())
            val shiftedIndex = charIndex + sectorID
            val clampedIndex = shiftedIndex % cypher.size
            val newChar = cypher[clampedIndex]
//            Log.v("Answer", "$char $charIndex $shiftedIndex $clampedIndex $newChar")
            decryptedName += newChar
        }
    }

    return decryptedName
}

@Composable
fun AOCDay4Part2(input: List<String>) {
    var part2Answer = 0

    input.forEach {
        val name = it.split('[')[0].dropLast(4)
        val sectorID = it.split('[')[0].split('-').last().toInt()

        val decryptedName = decryptName(name, sectorID)
        if(decryptedName.contains("pole", true)){
            Log.v("Answer", "$decryptedName $sectorID")
        }
    }

    Text(text = "Part 2 = $part2Answer")
}