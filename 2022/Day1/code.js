import { input } from "./input.js";

const yearNum = 2022;
const dayNum = 1;

function longStrIntoGrid(str) {
var strArr = str.split("\n");
var grid = [];
var newGridRow = [];
for (var i = 0; i < strArr.length; i++) {
	if (strArr[i] == "") {
	grid.push(newGridRow);
	newGridRow = [];
	} else {
	newGridRow.push(strArr[i]);
	}
}

return grid;
}

var inputGrid = longStrIntoGrid(input);

// ===== Part 1 =====

function findMaxRowInGrid(grid) {
var rowMax = 0;
grid.forEach((row) => {
	var currentRowSum = findSumOfIntArr(row);
	if (currentRowSum > rowMax) rowMax = currentRowSum;
});
return rowMax;
}

function findSumOfIntArr(intArr) {
var sum = 0;
intArr.forEach((int) => {
	sum += parseInt(int);
});
return sum;
}

var part1Answer = findMaxRowInGrid(inputGrid);
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function sortHighestToLowest(a, b) {
if (a > b) {
	return -1;
}
if (a < b) {
	return 1;
}
return 0;
}

function findTopRowSums(grid, numOfTopRows) {
var topSums = [];
grid.forEach((row) => {
	topSums.push(findSumOfIntArr(row));
	topSums.sort(sortHighestToLowest);
	topSums = topSums.slice(0, numOfTopRows);
});
return topSums;
}

var part2Answer = findSumOfIntArr(findTopRowSums(inputGrid, 3));
// console.log("Part 2 answer is: " + part2Answer);  

export { yearNum, dayNum, part1Answer, part2Answer, sortHighestToLowest };
