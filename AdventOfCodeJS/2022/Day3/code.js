import { input } from "./input.js";

const yearNum = 2022;
const dayNum = 3;

function formatInput(listOfStrAsLongStr) {
	var strArr = listOfStrAsLongStr.split("\n");
	var splitStrArr = [];
	strArr.forEach((str) => {
		var halfedStr = [];
		halfedStr.push(str.substring(0, str.split("").length / 2));
		halfedStr.push(str.substring(str.split("").length / 2));
		splitStrArr.push(halfedStr);
	});
	return splitStrArr;
}

const formattedInput = formatInput(input);

// ===== Part 1 =====
function findSimilarChars(str1, str2) {
	str1 = str1.toString();
	str2 = str2.toString();

	var similarChars = str1
		.split("")
		.filter((value) => str2.split("").includes(value));
	similarChars = [...new Set(similarChars)];

	var index = similarChars.indexOf(",");
	if (index !== -1) {
		similarChars.splice(index, 1);
	}

	return similarChars;
}

function convertLetterToNumber(character) {
	var num = 0;
	if (character == character.toLowerCase()) num += character.charCodeAt(0) - 96;
	else num += character.charCodeAt(0) - 38;

	return num;
}

function getPrioritySum(input) {
	var totalPrio = 0;
	input.forEach((strPair) => {
		var similarChars2 = findSimilarChars(strPair[0], strPair[1]);

		similarChars2.forEach((similarChar) => {
			totalPrio += convertLetterToNumber(similarChar);
		});
	});
	return totalPrio;
}

var part1Answer = getPrioritySum(formattedInput);
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function formatInput2(listOfStrAsLongStr) {
	var strArr = listOfStrAsLongStr.split("\n");
	var inputFormattedInThrees = [];

	for (var i = 0; i < strArr.length; i += 3) {
		var newGroup = [strArr[i], strArr[i + 1], strArr[i + 2]];
		inputFormattedInThrees.push(newGroup);
	}

	return inputFormattedInThrees;
}

var formattedInput2 = formatInput2(input);

function findSimilarCharsOf3Str(str1, str2, str3) {
	var similarCharsOneAndTwo = findSimilarChars(str1, str2);
	var similarCharsTwoAndThree = findSimilarChars(str2, str3);
	return findSimilarChars(similarCharsOneAndTwo, similarCharsTwoAndThree);
}

function getPrioritySum2(input) {
	var totalPrio = 0;
	var totalSimilarChars = "";
	formattedInput2.forEach((strTriplet) => {
		var similarChars = findSimilarCharsOf3Str(
			strTriplet[0],
			strTriplet[1],
			strTriplet[2]
		);
		totalSimilarChars += similarChars[0];
		var prio = convertLetterToNumber(similarChars[0]);
		// console.log(similarChars + " " + prio);
		totalPrio += prio;
	});
	console.log(totalSimilarChars);
	return totalPrio;
}

var part2Answer = getPrioritySum2(formattedInput2);
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
