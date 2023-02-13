package com.android.aoc2016

import android.util.Log
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
fun AOCDay5Preview() {
    AOCDay5()
}

@Composable
fun AOCDay5() {
    val dayNum = 5

    val day5TestInput = "abc"
    val day5RawInput = "ffykfhsq"

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay5Part1(day5RawInput)
        Text(text = "|")
        AOCDay5Part2(day5RawInput)
    }
}

fun findPassword(input: String): String {
    var num = -1
    var password = ""

    while (password.length < 8) {
        num++
        val hash = md5(input + num)
        if(hash.indexOf("00000") == 0) {
            password += hash.substring(5, 6)
            Log.v("Creating Password", "$password")
        }
    }

    Log.v("Final Password", "$password")
    return password
}

// From: https://stackoverflow.com/questions/64171624/how-to-generate-an-md5-hash-in-kotlin
fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

@Composable
fun AOCDay5Part1(input: String) {
    val password = findPassword(input)

    Log.v("Answer", "Part 1 Answer: $password")
    Text(text = "Part 1 = $password")
}

fun findPassword2(input: String): String {
    var num = -1
    var password = mutableListOf('-', '-', '-', '-', '-', '-', '-', '-')

    while (password.contains('-')) {
        num++
        val hash = md5(input + num)
        if(hash.indexOf("00000") == 0) {
            val position = hash.substring(5, 6).toIntOrNull()
            if(position != null
                && position < password.size
                && password[position] == '-') {
                val char = hash.toCharArray()[6]
                password[position] = char
                Log.v("Creating Password", "$password")
            }
        }
    }

    val finalPassword = password.toString()
        .replace("[", "")
        .replace("]", "")
        .replace(", ", "")

    Log.v("Final Password", finalPassword)
    return finalPassword
}

@Composable
fun AOCDay5Part2(input: String) {
    val password2 = findPassword2(input)

    Log.v("Answer", "Part 2 Answer: $password2")
    Text(text = "Part 2 = $password2")
}