import { layout, commands } from "./input.js";

const yearNum = 2022;
const dayNum = 5;

function copy2dArr(initLayout) {
	var newArray = [];

	for (var i = 0; i < initLayout.length; i++)
		newArray[i] = initLayout[i].slice();

	return newArray;
}

function formatCommands(commands) {
	var commandsF = [];
	commands.split("\n").forEach((commandLine) => {
		var newCommandLineF = commandLine.split(" ");

		var index1 = newCommandLineF.indexOf("move");
		if (index1 !== -1) {
			newCommandLineF.splice(index1, 1);
		}
		var index2 = newCommandLineF.indexOf("from");
		if (index2 !== -1) {
			newCommandLineF.splice(index2, 1);
		}
		var index3 = newCommandLineF.indexOf("to");
		if (index3 !== -1) {
			newCommandLineF.splice(index3, 1);
		}

		commandsF.push(newCommandLineF);
	});
	console.log(commandsF);
	return commandsF;
}

const commandsF = formatCommands(commands);

// ===== Part 1 =====

function moveCrate(layout1, startingIndex, endingIndex) {
	var removedCrate = layout1[startingIndex].pop();
	layout1[endingIndex].push(removedCrate);
	return layout1;
}

function issueCommands(layout1, commands) {
	commands.forEach((command) => {
		var moveCount = parseInt(command[0]);
		var startingIndex = parseInt(command[1]) - 1;
		var endingIndex = parseInt(command[2]) - 1;

		for (var i = 0; i < moveCount; i++) {
			layout1 = moveCrate(layout1, startingIndex, endingIndex);
		}
	});
	return layout1;
}

function getTopCrates(rowsOfCrates) {
	var returnStr = "";
	rowsOfCrates.forEach((row) => {
		var lastIndex = row.length - 1;
		returnStr += row[lastIndex];
	});
	return returnStr;
}

var initLayout1 = copy2dArr(layout);
var part1Answer = getTopCrates(issueCommands(initLayout1, commandsF));
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function moveCrate2(layout2, amountMoved, startingIndex, endingIndex) {
	var spliceStartingIndex = layout2[startingIndex].length - amountMoved;
	var removedCrates = layout2[startingIndex].splice(spliceStartingIndex);
	layout2[endingIndex] = layout2[endingIndex].concat(removedCrates);
	return layout2;
}

function issueCommands2(layout2, commands) {
	commands.forEach((command) => {
		var moveCount = parseInt(command[0]);
		var startingIndex = parseInt(command[1]) - 1;
		var endingIndex = parseInt(command[2]) - 1;

		layout2 = moveCrate2(layout2, moveCount, startingIndex, endingIndex);
	});
	return layout2;
}

var initLayout2 = copy2dArr(layout);
var part2Answer = getTopCrates(issueCommands2(initLayout2, commandsF));
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
