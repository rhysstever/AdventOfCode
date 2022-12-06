import { input } from "./input.js";

const yearNum = 2021;
const dayNum = 1;

// ===== Part 1 =====

var increases = 0;
for (var i = 1; i < input.length; i++) {
  var prevDepth = input[i - 1];
  var currentDepth = input[i];
  if (currentDepth > prevDepth) increases++;
}

var part1Answer = increases;
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

var sumIncreases = 0;
for (var i = 1; i < input.length - 2; i++) {
  var currentDepthSum = input[i - 1] + input[i] + input[i + 1];
  var nextDepthSum = input[i] + input[i + 1] + input[i + 2];
  if (nextDepthSum > currentDepthSum) sumIncreases++;
}

var part2Answer = sumIncreases;
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
