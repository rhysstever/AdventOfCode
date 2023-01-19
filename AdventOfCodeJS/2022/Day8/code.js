import { input } from "./input.js";

const yearNum = 2022;
const dayNum = 8;

function longStrIntoGrid(input) {
  var grid = [];
  var inputInRows = input.split("\n");
  inputInRows.forEach((row) => {
    var formattedRow = [];
    var rowOfChars = row.split("");
    rowOfChars.forEach((char) => {
      var num = parseInt(char);
      formattedRow.push(num);
    });
    grid.push(formattedRow);
  });
  return grid;
}

const inputF = longStrIntoGrid(input);

// ===== Part 1 =====

function getMax(arr) {
  var max = arr[0];
  arr.forEach((element) => {
    max = Math.max(element, max);
  });
  return max;
}

function isVisibleLeft(grid, row, colStart) {
  var slice = grid[row].slice(0, colStart);
  var max = getMax(slice);
  if (max < grid[row][colStart]) return 1;
  else return -1;
}

function isVisibleRight(grid, row, colStart) {
  var slice = grid[row].slice(colStart + 1, grid[row].length);
  var max = getMax(slice);
  if (max < grid[row][colStart]) return 1;
  else return -1;
}

function isVisibleAbove(grid, rowStart, col) {
  var slice = [];
  for (var i = rowStart - 1; i >= 0; i--) {
    slice.push(grid[i][col]);
  }

  var max = getMax(slice);
  if (max < grid[rowStart][col]) return 1;
  else return -1;
}

function isVisibleBelow(grid, rowStart, col) {
  var slice = [];
  for (var i = rowStart + 1; i < grid.length; i++) {
    slice.push(grid[i][col]);
  }

  var max = getMax(slice);
  if (max < grid[rowStart][col]) return 1;
  else return -1;
}

function isVisible(grid, x, y) {
  // Check if edge
  if (x === 0 || y === 0 || x === grid.length - 1 || y === grid[0].length - 1)
    return 1;

  // Check if it can be seen in any direction
  if (
    isVisibleLeft(grid, x, y) > 0 ||
    isVisibleRight(grid, x, y) > 0 ||
    isVisibleAbove(grid, x, y) > 0 ||
    isVisibleBelow(grid, x, y) > 0
  )
    return 1;

  return -1;
}

function totalVisibleTrees(grid) {
  var visibleTreesCount = 0;
  for (var r = 0; r < grid.length; r++) {
    for (var c = 0; c < grid[r].length; c++) {
      if (isVisible(grid, r, c) > 0) visibleTreesCount++;
    }
  }
  return visibleTreesCount;
}

var part1Answer = totalVisibleTrees(inputF);
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function countVisibleTreesLeft(grid, row, col) {
  var count = 0;
  for (var i = col - 1; i >= 0; i--) {
    if (grid[row][i] < grid[row][col]) {
      count++;
    } else {
      return ++count;
    }
  }
  return count;
}

function countVisibleTreesRight(grid, row, col) {
  var count = 0;
  for (var i = col + 1; i < grid[row].length; i++) {
    if (grid[row][i] < grid[row][col]) {
      count++;
    } else {
      return ++count;
    }
  }
  return count;
}

function countVisibleTreesAbove(grid, row, col) {
  var count = 0;
  for (var i = row - 1; i >= 0; i--) {
    if (grid[i][col] < grid[row][col]) {
      count++;
    } else {
      return ++count;
    }
  }
  return count;
}

function countVisibleTreesBelow(grid, row, col) {
  var count = 0;
  for (var i = row + 1; i < grid.length; i++) {
    if (grid[i][col] < grid[row][col]) {
      count++;
    } else {
      return ++count;
    }
  }
  return count;
}

function getScenicScoreOfPoint(grid, row, col) {
  var left = countVisibleTreesLeft(grid, row, col);
  var right = countVisibleTreesRight(grid, row, col);
  var above = countVisibleTreesAbove(grid, row, col);
  var below = countVisibleTreesBelow(grid, row, col);
  return left * right * above * below;
}

function getHighestScenicScore(grid) {
  var maxScenicScore = -1;
  for (var r = 0; r < grid.length; r++) {
    for (var c = 0; c < grid[r].length; c++) {
      var currentScenicScore = getScenicScoreOfPoint(grid, r, c);
      if (currentScenicScore > maxScenicScore) {
        maxScenicScore = currentScenicScore;
      }
    }
  }
  return maxScenicScore;
}

var part2Answer = getHighestScenicScore(inputF);
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
