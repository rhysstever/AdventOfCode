import { input } from "./input.js";

const yearNum = 2015;
const dayNum = 2;

function formatInput(input) {
  var inputF = [];
  var rows = input.split("\n");
  rows.forEach((row) => {
    var chars = row.split("x");
    var rowF = [];
    rowF.push(parseInt(chars[0]));
    rowF.push(parseInt(chars[1]));
    rowF.push(parseInt(chars[2]));
    inputF.push(rowF);
  });

  return inputF;
}

const inputF = formatInput(input);

// ===== Part 1 =====

function getRectPrismSurfAreaPlusSlack(length, width, height) {
  var side1 = length * width;
  var side2 = width * height;
  var side3 = height * length;
  var slack = Math.min(side1, side2, side3);
  var total = 2 * side1 + 2 * side2 + 2 * side3 + slack;
  return total;
}

function getTotalSurfaceArea(arr) {
  var total = 0;
  arr.forEach((dims) => {
    total += getRectPrismSurfAreaPlusSlack(dims[0], dims[1], dims[2]);
  });
  return total;
}

var part1Answer = getTotalSurfaceArea(inputF);
console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function getRectPrismVolume(length, width, height) {
  return length * width * height;
}

function getSmallestPerimeter(length, width, height) {
  var side1 = 2 * (length + width);
  var side2 = 2 * (width + height);
  var side3 = 2 * (height + length);
  return Math.min(side1, side2, side3);
}

function getTotalRibbonLenth(arr) {
  var total = 0;
  arr.forEach((dims) => {
    total +=
      getRectPrismVolume(dims[0], dims[1], dims[2]) +
      getSmallestPerimeter(dims[0], dims[1], dims[2]);
  });
  return total;
}

var part2Answer = getTotalRibbonLenth(inputF);
console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
