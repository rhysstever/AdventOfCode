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
fun AOCDay7Preview() {
    AOCDay7()
}

@Composable
fun AOCDay7() {
    val dayNum = 7

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = "Day $dayNum:")
        AOCDay7Part1(day7RawInput)
        Text(text = "|")
        AOCDay7Part2("")
    }
}

fun formatInput(input: List<String>): List<List<String>> {
    var formattedInput = mutableListOf<List<String>>()
    input.forEach {
        val line = it.split(" -> ")
        formattedInput.add(line)
    }
    return formattedInput
}

fun parseInput(input: List<List<String>>): MutableMap<String, Int> {
    val map = mutableMapOf<String, Int>()

    input.forEach {
        if(it[0].contains("AND")) {
            val num1 = map[it[0].split(" AND ")[0]]
            val num2 = map[it[0].split(" AND ")[1]]
            val newVal = num1!!.and(num2!!)
            Log.v("AOC Answer: AND", "${it[1]}: $newVal")
            map[it[1]] = newVal
        }
        else if(it[0].contains("OR")) {
            val num1 = map[it[0].split(" OR ")[0]]
            val num2 = map[it[0].split(" OR ")[1]]
            val newVal = num1!!.or(num2!!)
            Log.v("AOC Answer: OR", "${it[1]}: $newVal")
            map[it[1]] = newVal
        }
        else if(it[0].contains("LSHIFT")) {
            val key = it[0].split(" LSHIFT ")[0]
            val keyVal = map[key]
            val shiftNum = it[0].split(" LSHIFT ")[1].toInt()
            val newVal = keyVal!! shl shiftNum
            Log.v("AOC Answer: LSHIFT", "${it[1]}: $newVal")
            map[it[1]] = newVal
        }
        else if(it[0].contains("RSHIFT")) {
            val key = it[0].split(" RSHIFT ")[0]
            val keyVal = map[key]
            val shiftNum = it[0].split(" RSHIFT ")[1].toInt()
            val newVal = keyVal!! shr shiftNum
            Log.v("AOC Answer: RSHIFT", "${it[1]}: $newVal")
            map[it[1]] = newVal
        }
        else if(it[0].contains("NOT")) {
            val key = it[0].substring(4)
            val keyVal = map[key]
            val newVal = keyVal!!.inv()
            Log.v("AOC Answer: NOT", "${it[1]}: $newVal")
            map[it[1]] = newVal
        }
        else if(it[0].toIntOrNull() != null) {
            val newVal = it[0].toInt()
            Log.v("AOC Answer: Set", "${it[1]}: $newVal")
            map[it[1]] = newVal
        }
    }

    Log.v("AOC Answer", map.toString())
    return map
}

@Composable
fun AOCDay7Part1(input: List<String>) {
    val formattedInput = formatInput(input)
    val parsedInput = parseInput(formattedInput)

    Text(text = "Part 1 = ${parsedInput["a"]}")
}

@Composable
fun AOCDay7Part2(input: String) {
    val part2Answer = 0

    Text(text = "Part 2 = $part2Answer")
}