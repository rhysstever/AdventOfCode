import { input } from "./inputs/Day6Input.js";

const inputCharArr = input.split("");

// ===== Part 1 =====

function findMarkerStartingIndex(charArr, numOfChars) {
	var tempArr = [];
	for(var i = 0; i < charArr.length; i++) {
		tempArr.push(charArr[i]);
		if(tempArr.length > numOfChars)
			tempArr.shift();

		var dupsCheckArr = [...new Set(tempArr)];
		if(dupsCheckArr.length == numOfChars) return i + 1;
	}

	return -1;
}

var startOfPacketMarker = findMarkerStartingIndex(inputCharArr, 4);
// console.log("Part 1 answer is: " + startOfPacketMarker);

// ===== Part 2 =====

var startOfPacketMessage = findMarkerStartingIndex(inputCharArr, 14);
// console.log("Part 2 answer is: " + startOfPacketMessage);

export { startOfPacketMarker, startOfPacketMessage };
