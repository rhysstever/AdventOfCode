import { input } from "./inputs/Day1Input.js";

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

var rowMax = findMaxRowInGrid(inputGrid);
// console.log("Part 1 answer is: " + rowMax);

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

var top3RowSums = findSumOfIntArr(findTopRowSums(inputGrid, 3));
// console.log("Part 2 answer is: " + top3RowSums);

export { rowMax, top3RowSums, sortHighestToLowest };
