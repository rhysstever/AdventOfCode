import { input } from "./input.js";

const yearNum = 2015;
const dayNum = 1;

const inputF = input.split("");

// ===== Part 1 =====

function findFinalFloor(arr) {
  var counter = 0;
  arr.forEach((char) => {
    if (char === "(") ++counter;
    else if (char === ")") --counter;
  });
  return counter;
}

var part1Answer = findFinalFloor(inputF);
console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function findPositionOfFirstBasement(arr) {
  var currentFloor = 0;
  for (var i = 0; i < arr.length; i++) {
    var char = arr[i];
    if (char === "(") ++currentFloor;
    else if (char === ")") --currentFloor;

    if (currentFloor == -1) return i + 1;
  }
  return -1;
}

var part2Answer = findPositionOfFirstBasement(inputF);
console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
