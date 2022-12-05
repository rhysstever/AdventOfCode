const rawInput = require("./inputs/Day4Input.js").input;

function formatInput(input) {
	var formattedInput = [];
	var linedInput = input.split('\n');
	linedInput.forEach(line => {
		var row = [];
		line.split(',').forEach(rowPair => {
			row.push(rowPair.split('-'));
		});
		formattedInput.push(row);
	});

	return formattedInput;
}

const inputF = formatInput(rawInput);

// ===== Part 1 =====

function isSubstring(min1, max1, min2, max2) {
	console.log(min1 + " " + max1 + " " + min2 + " " + max2);
	var isSubstr = (min1 <= min2 && max1 >= max2) || (min1 >= min2 && max1 <= max2);
	console.log(isSubstr);
	return isSubstr;
}

var subStrCounter = 0;
inputF.forEach(pair => {
	if(isSubstring(pair[0][0], pair[0][1], pair[1][0], pair[1][1]));
		subStrCounter++;
});

console.log("Part 1 answer is: " + subStrCounter);

// ===== Part 2 =====

var part2Answer = 0;
// console.log("Part 2 answer is: " + part2Answer);

// export { part1Answer, part2Answer };
