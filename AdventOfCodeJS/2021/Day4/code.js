import { numsCalledInput, boardInput } from "./input.js";

const yearNum = 2021;
const dayNum = 4;

function plainTextGridsIntoArrays(input) {
	var formattedGrids = [];
	input.split("\n\n").forEach((grid) => {
	  formattedGrids.push(grid.split("\n"));
	});
  
	for (var gridNum = 0; gridNum < formattedGrids.length; gridNum++) {
	  for (var row = 0; row < formattedGrids[gridNum].length; row++) {
		formattedGrids[gridNum][row] = formattedGrids[gridNum][row]
		  .split(" ")
		  .filter((i) => i);
	  }
	}
  
	return formattedGrids;
  }
  
  var playableBoards = plainTextGridsIntoArrays(boardInput);
  
  // ===== Part 1 =====
  
  function numberOfCallsTillBingo(boardGrid, numsCalledArr) {
	var shortestCallout = Number.MAX_SAFE_INTEGER;
	var tempShortestCallout = 0;
  
	// Check each row
	for (var r = 0; r < boardGrid.length; r++) {
	  tempShortestCallout = getHighestInArr(boardGrid[r], numsCalledArr);
	  if (tempShortestCallout < shortestCallout) {
		shortestCallout = tempShortestCallout;
	  }
	}
  
	// Check every column
	for (var c = 0; c < boardGrid[0].length; c++) {
	  var newCol = [];
	  for (var r = 0; r < boardGrid.length; r++) {
		newCol.push(boardGrid[r][c]);
	  }
  
	  tempShortestCallout = getHighestInArr(newCol, numsCalledArr);
	  if (tempShortestCallout < shortestCallout) {
		shortestCallout = tempShortestCallout;
	  }
	}
  
	return shortestCallout;
  }
  
  function getHighestInArr(arr, numCalledArr) {
	var highestInArr = -1;
	arr.forEach((element) => {
	  var intElem = parseInt(element);
	  var calledIndex = numCalledArr.indexOf(intElem);
	  if (calledIndex > highestInArr) highestInArr = calledIndex;
	});
  
	return highestInArr;
  }
  
  var fewestCallsForBingo = Number.MAX_SAFE_INTEGER;
  var bestGridIndex = -1;
  for (var grid = 0; grid < playableBoards.length; grid++) {
	var callsForBingo = numberOfCallsTillBingo(
	  playableBoards[grid],
	  numsCalledInput
	);
	if (callsForBingo < fewestCallsForBingo) {
	  fewestCallsForBingo = callsForBingo;
	  bestGridIndex = grid;
	}
  }
  
  function sumUncalledBoard(boardGrid, numOfCalledNumbers, calledNumArr) {
	var boardSum = 0;
	for (var r = 0; r < boardGrid.length; r++) {
	  for (var c = 0; c < boardGrid[0].length; c++) {
		var indexInCalledNumsArr = calledNumArr.indexOf(
		  parseInt(boardGrid[r][c])
		);
		if (indexInCalledNumsArr > numOfCalledNumbers)
		  boardSum += parseInt(boardGrid[r][c]);
	  }
	}
  
	return boardSum;
  }
  
  var lastNumCalled = numsCalledInput[fewestCallsForBingo];
  
  var bestBoardSum = sumUncalledBoard(
	playableBoards[bestGridIndex],
	fewestCallsForBingo,
	numsCalledInput
  );
  
  var part1Answer = bestBoardSum * lastNumCalled;
  // console.log("Part 1 answer is: " + part1Answer);
  
  // ===== Part 2 =====
  
  var mostCallsForBingo = 0;
  var worstGridIndex = -1;
  for (var grid = 0; grid < playableBoards.length; grid++) {
	var callsForBingo = numberOfCallsTillBingo(
	  playableBoards[grid],
	  numsCalledInput
	);
	if (callsForBingo > mostCallsForBingo) {
	  mostCallsForBingo = callsForBingo;
	  worstGridIndex = grid;
	}
  }
  
  var lastNumCalled2 = numsCalledInput[mostCallsForBingo];
  
  var worstBoardSum = sumUncalledBoard(
	playableBoards[worstGridIndex],
	mostCallsForBingo,
	numsCalledInput
  );
  
  var part2Answer = worstBoardSum * lastNumCalled2;
  // console.log("Part 1 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
