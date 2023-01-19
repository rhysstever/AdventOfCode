import { input, testInput } from "./input.js";

const yearNum = 2000;
const dayNum = 0;

function formatInput(input) {
  var formattedInput = [];
  input.split("\n").forEach((commandLine) => {
    var commandRow = commandLine.split(" ");
    if (commandRow[0] === "addx") formattedInput.push(["noop"]);
    formattedInput.push(commandRow);
  });
  return formattedInput;
}

const testInputF = formatInput(testInput);
const inputF = formatInput(input);

// ===== Part 1 =====

function findSignal(input, index) {
  var sum = 1;

  for (var i = 0; i < index - 1; i++) {
    if (input[i][0] == "addx") {
      var num = parseInt(input[i][1]);
      sum += num;
    }
  }
  return sum * index;
}

function sumSignals(input, indices) {
  var total = 0;
  indices.forEach((index) => {
    total += findSignal(input, index);
  });
  return total;
}

var indices = [20, 60, 100, 140, 180, 220];
var part1Answer = sumSignals(inputF, indices);
console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

var part2Answer = 0;
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
