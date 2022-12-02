import { input } from "./inputs/Day1Input.js";

// ===== Part 1 =====

var increases = 0;
for (var i = 1; i < input.length; i++) {
  var prevDepth = input[i - 1];
  var currentDepth = input[i];
  if (currentDepth > prevDepth) increases++;
}

// console.log("Part 1 answer is: " + increases);

// ===== Part 2 =====

var sumIncreases = 0;
for (var i = 1; i < input.length - 2; i++) {
  var currentDepthSum = input[i - 1] + input[i] + input[i + 1];
  var nextDepthSum = input[i] + input[i + 1] + input[i + 2];
  if (nextDepthSum > currentDepthSum) sumIncreases++;
}

// console.log("Part 2 answer is: " + sumIncreases);

export { increases, sumIncreases };
