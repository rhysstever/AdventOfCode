import { input } from "./inputs/Day4Input.js";

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

const inputF = formatInput(input);

// ===== Part 1 =====

function isOverlapping(pair1, pair2, allowPartialOverlap) {
	var min1 = parseInt(pair1[0]);
	var max1 = parseInt(pair1[1]);
	var min2 = parseInt(pair2[0]);
	var max2 = parseInt(pair2[1]);

	if(allowPartialOverlap)
		if((min1 <= min2 && max1 >= min2) || (min2 <= min1 && max2 >= min1))
			return 1;

	if((min1 <= min2 && max1 >= max2) || (min1 >= min2 && max1 <= max2))
		return 1;
	else 
		return -1;
}

function countOverlaps(pairsArr, allowPartialOverlap) {
	var count = 0;
	pairsArr.forEach(pair => {
		if(isOverlapping(pair[0], pair[1], allowPartialOverlap) > 0) {
			count++;
		}
	});
	return count;
}

var subStrCounter1 = countOverlaps(inputF, false);
// console.log("Part 1 answer is: " + subStrCounter1);

// ===== Part 2 =====

var subStrCounter2 = countOverlaps(inputF, true);
// console.log("Part 2 answer is: " + subStrCounter2);

export { subStrCounter1, subStrCounter2 };
