import { indexX, indexY } from "./input.js";

const yearNum = 2015;
const dayNum = 25;

// ===== Part 1 =====

function incrementCode(currentCode) {
  var multipliedCode = currentCode * 252533;
  var remainingCode = multipliedCode % 33554393;
  return remainingCode;
}

function findCodeAtIndex(index) {
  var currentCode = 20151125;
  for (var i = 1; i < index; i++) {
    currentCode = incrementCode(currentCode);
  }
  return currentCode;
}

function getCodeOfCertainCell(x, y) {
  var max = Math.max(x, y);
  var arr = new Array(max);
  arr.forEach((row) => {
    row.push(new Array(max));
  });

  var currentCode = 20151125;

  return arr[x][y];
}

var part1Answer = getCodeOfCertainCell();
console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

var part2Answer = 0;
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
