import { input, testInput } from "./input.js";

const yearNum = 2022;
const dayNum = 10;

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

function findSum(input, index) {
  var sum = 1;

  for (var i = 0; i < index - 1; i++) {
    if (input[i][0] == "addx") {
      var num = parseInt(input[i][1]);
      sum += num;
    }
  }
  return sum;
}

function sumSignals(input, indices) {
  var total = 0;
  indices.forEach((index) => {
    total += findSum(input, index) * index;
  });
  return total;
}

var indices = [20, 60, 100, 140, 180, 220];
var part1Answer = sumSignals(inputF, indices);
console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function findPixelChar(cycle, pos) {
  var sprite = Array(40);
  sprite.fill(".");
  
  var trunkedCycle = cycle % 40;
  sprite[trunkedCycle] = "#";
  sprite[trunkedCycle + 1] = "#";
  sprite[trunkedCycle + 2] = "#";

  console.log("Cycle: " + cycle + " Trunked Cycle: " + trunkedCycle + " Pos: " + pos + " Sprite: " + sprite[pos])

  return sprite[pos];
}

function findLine(input) {
  var str = "";
  var total = 1;
  for(var i = 0; i < 40; i++) {
    str += findPixelChar(i, total);
    console.log(findSignal(input, i));
    total = findSignal(input, i);
  }
  return str;
}

var index = 4;
for(var i = 0; i < index; i++) {
  var total = findSum(testInputF, i + 2);
  findPixelChar(i, total);
}

var part2Answer = 0;
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
