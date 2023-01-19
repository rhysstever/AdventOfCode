import { input } from "./input.js";

const yearNum = 2021;
const dayNum = 5;

function formatInput(input) {
	var formattedInput = input.split("\n");
	for (var line = 0; line < formattedInput.length; line++) {
	  formattedInput[line] = formattedInput[line].split(" -> ");
	  for (var pair = 0; pair < formattedInput[line].length; pair++) {
		formattedInput[line][pair] = formattedInput[line][pair].split(",");
		for (var num = 0; num < formattedInput[line][pair].length; num++) {
		  formattedInput[line][pair][num] = parseInt(
			formattedInput[line][pair][num]
		  );
		}
	  }
	}
  
	return formattedInput;
  }
  
  const inputF = formatInput(input);
  // ===== Part 1 =====
  
  function findMaxOf3DArr(arr) {
	var max = -1;
	for (var i = 0; i < arr.length; i++) {
	  for (var j = 0; j < arr[i].length; j++) {
		for (var k = 0; k < arr[i][j].length; k++) {
		  if (arr[i][j][k] > max) {
			max = arr[i][j][k];
		  }
		}
	  }
	}
	return max;
  }
  
  function make2DArr(size1, size2) {
	var grid = [];
	for (var i = 0; i < size1; i++) {
	  grid[i] = [];
	  for (var j = 0; j < size2; j++) {
		grid[i][j] = 0;
	  }
	}
	return grid;
  }
  
  function addLine(grid, x1, y1, x2, y2, isDiagAllowed) {
	// Only vert or horiz lines
	if (!isDiagAllowed) if (x1 != x2 && y1 != y2) return;
  
	var xCurrent = x1;
	var yCurrent = y1;
  
	var xDir = getDirection(x1, x2);
	var yDir = getDirection(y1, y2);
  
	while (xCurrent != x2 || yCurrent != y2) {
	  grid[xCurrent][yCurrent]++;
  
	  if (xCurrent != x2) xCurrent += xDir;
	  if (yCurrent != y2) yCurrent += yDir;
	}
	// Add where x1 == xCurrent == x2 && y1 == yCurrent == y2
	grid[xCurrent][yCurrent]++;
  }
  
  function getDirection(p1, p2) {
	return (p2 - p1) / Math.abs(p2 - p1);
  }
  
  function fillGrid(grid, input, isDiagAllowed) {
	input.forEach((line) => {
	  addLine(
		grid,
		line[0][0],
		line[0][1],
		line[1][0],
		line[1][1],
		isDiagAllowed
	  );
	});
  }
  
  function getCountAbove(grid, numToCount) {
	var counter = 0;
	for (var i = 0; i < grid.length; i++) {
	  for (var j = 0; j < grid[i].length; j++) {
		if (grid[i][j] > numToCount) counter++;
	  }
	}
	return counter;
  }
  
  var max = findMaxOf3DArr(inputF);
  
  var grid1 = make2DArr(max, max);
  fillGrid(grid1, inputF, false);
  
  var part1Answer = getCountAbove(grid1, 1);
  // console.log("Part 1 answer is: " + part1Answer);
  
  // ===== Part 2 =====
  
  var grid2 = make2DArr(max, max);
  fillGrid(grid2, inputF, true);
  
  var part2Answer = getCountAbove(grid2, 1);
  // console.log("Part 2 answer is: " + part2Answer);  

export { yearNum, dayNum, part1Answer, part2Answer };
