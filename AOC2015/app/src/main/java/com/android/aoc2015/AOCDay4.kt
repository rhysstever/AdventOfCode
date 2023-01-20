package com.android.aoc2015

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.math.BigInteger
import java.security.MessageDigest

@Preview
@Composable
fun AOCDay4Preview() {
    AOCDay4()
}

@Composable
fun AOCDay4() {
    val dayNum = 4
    val day4RawInput = "ckczppom"

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay4Part1(day4RawInput)
        Text(text = "|")
        AOCDay4Part2(day4RawInput)
    }
}

// Code from Stack Overflow: https://stackoverflow.com/questions/64171624/how-to-generate-an-md5-hash-in-kotlin
fun ConvertStrToMD5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

fun HasLeadingZeros(input: String, numOfLeadingZeros: Int): Boolean {
    val inputCharArr = input.toCharArray().slice(0 until numOfLeadingZeros)
    inputCharArr.forEach {
        if(it != '0')
            return false
    }
    return true
}

@Composable
fun AOCDay4Part1(input: String) {
    var answerNum = 0

    do {
        answerNum++
        val md5Input = input + answerNum
        val md5Hash = ConvertStrToMD5(md5Input)
    } while (!HasLeadingZeros(md5Hash, 5))

    Text(text = "Part 1 = $answerNum")
}

@Composable
fun AOCDay4Part2(input: String) {
    var answerNum = 0

    do {
        answerNum++
        val md5Input = input + answerNum
        val md5Hash = ConvertStrToMD5(md5Input)
    } while (!HasLeadingZeros(md5Hash, 6))

    Text(text = "Part 2 = $answerNum")
}