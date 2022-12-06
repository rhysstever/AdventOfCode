import { input } from "./input.js";

const yearNum = 2022;
const dayNum = 2;

function formatInput(longStr) {
	var formattedInput = [];
	var arrOfLines = longStr.split("\n");
	arrOfLines.forEach((lines) => {
	  formattedInput.push(lines.split(" "));
	});
	return formattedInput;
}

const formattedInput = formatInput(input);

// ===== Part 1 =====

function parseSign(signLetter) {
	var signCipher = {
		A: 1,
		B: 2,
		C: 3,
		X: 1,
		Y: 2,
		Z: 3,
		default: -1,
	};

	return signCipher[signLetter];
}

function parseMatchData(play1, play2) {
	var matchScore = play2;

	if (play1 == play2) matchScore += 3;
	else if (play1 == 3 && play2 == 1) matchScore += 6;
	else if (play1 == 1 && play2 == 3) matchScore += 0;
	else if (play1 > play2) matchScore += 0;
	else matchScore += 6;

	return matchScore;
}

function getMatchScores(allMatchData) {
	var matchScoreTotal = 0;
	allMatchData.forEach((match) => {
		var opponentPlay = parseSign(match[0]);
		var selfPlay = parseSign(match[1]);
		matchScoreTotal += parseMatchData(opponentPlay, selfPlay);
	});

	return matchScoreTotal;
}

var part1Answer = getMatchScores(formattedInput);
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function findSelfSign(opponentInput, result) {
	var selfSign = -1;

	// Tie
	if (result == 3) selfSign = opponentInput;
	// Loss
	else if (result == 0) {
		if (opponentInput == 1) selfSign = 3;
		else selfSign = opponentInput - 1;
	}
	// Win
	else if (result == 6) {
		if (opponentInput == 3) selfSign = 1;
		else selfSign = opponentInput + 1;
	}

	return selfSign;
}

function parseMatchResult(matchResult) {
	var matchResultCipher = {
		X: 0,
		Y: 3,
		Z: 6,
	};
	return matchResultCipher[matchResult];
}

function getMatchScores2(allMatchData) {
	var matchScoreTotal = 0;
	allMatchData.forEach((match) => {
		var opponentPlay = parseSign(match[0]);
		var matchResult = parseMatchResult(match[1]);
		var selfPlay = findSelfSign(opponentPlay, matchResult);
		matchScoreTotal += parseMatchData(opponentPlay, selfPlay);
	});

	return matchScoreTotal;
}

var part2Answer = getMatchScores2(formattedInput);
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
