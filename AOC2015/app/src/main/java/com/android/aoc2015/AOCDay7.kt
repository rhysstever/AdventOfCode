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
        AOCDay7Part1(day7TestInput)
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

fun setValues(instructionList: List<List<String>>): Map<String, String> {
    var map = mutableMapOf<String, String>()

    instructionList.forEach {
        map[it[1]] = it[0]
    }

//    Log.v("AOC Answer", map.toString())
    return map
}

fun findAssignment(instructionList: List<List<String>>, key: String): String {
    instructionList.forEach {
        if(it[1] == key)
            return it[0]
    }

    return "No Assignment was found"
}

fun isOperation(instruction: String): Boolean {
    return (instruction.contains("AND")
        || instruction.contains("OR")
        || instruction.contains("SHIFT")
        || instruction.contains("NOT"))
}

//fun processOperation(map: Map<String, String>, instruction: String): String {
//    if(instruction.contains("AND")) {
//        val split = instruction.split(" AND ")
//        val val1 = split[0]
//        val key2 = split[2]
//        return
//    }
//    else if(instruction.contains("OR"))
//        return instruction.split(" OR ")
//    else if(instruction.contains("LSHIFT"))
//        return instruction.split(" LSHIFT ")
//    else if(instruction.contains("RSHIFT"))
//        return instruction.split(" RSHIFT ")
//    else if(instruction.contains("NOT"))
//        return instruction.split(" NOT ")
//    else
//        return listOf(instruction, "")
//}

fun process(map: Map<String, String>) {
    map.forEach {
        if(isOperation(it.value)) {
//            val strArr = processOperation(map, it.value)
//            Log.v("AOC Answer", strArr.toString())
        } else {
            val key = it.key
            var newVal = it.value
            var mapVal = map[it.value]
            if(mapVal != null)
                newVal = mapVal
//            Log.v("AOC Answer", "$key: $newVal")
        }
    }
}

fun andOperation(keyVal1: Int, keyVal2: Int): Int {
    return keyVal1.and(keyVal2)
}

fun orOperation(keyVal1: Int, keyVal2: Int): Int {
    return keyVal1.or(keyVal2)
}

fun shiftLeftOperation(keyVal: Int, shiftAmount: Int): Int {
    return keyVal shl shiftAmount
}

fun shiftRightOperation(keyVal: Int, shiftAmount: Int): Int {
    return keyVal shr shiftAmount
}

fun notOperation(keyVal: Int): Int {
    return keyVal.inv().and(65535)
}

@Composable
fun AOCDay7Part1(input: List<String>) {
    val formattedInput = formatInput(input)
    val map = setValues(formattedInput)
    process(map)

//    val test = process(formattedInput, "d")
//    Log.v("AOC Answer: Result", "$test")

//    Text(text = "Part 1 = ${parsedInput["a"]}")
}

@Composable
fun AOCDay7Part2(input: String) {
    val part2Answer = 0

    Text(text = "Part 2 = $part2Answer")
}