import { input } from "./inputs/Day2Input.js";

// ===== Part 1 =====

function parseMovement(movement, amount) {
  var movements = {
    forward: [amount, 0],
    down: [0, amount],
    up: [0, -amount],
  };

  return movements[movement];
}

var position = [0, 0];
input.forEach((singleMove) => {
  var parsedInput = singleMove.split(" ");
  var parsedMove = parseMovement(parsedInput[0], parseInt(parsedInput[1]));
  position[0] += parsedMove[0];
  position[1] += parsedMove[1];
});

var totalMove = position[0] * position[1];
// console.log("Part 1 answer is: " + totalMove);

// ===== Part 2 =====

function parseMovement2(movement, amount) {
  var movements = {
    forward: [amount, amount * aim, 0],
    down: [0, 0, amount],
    up: [0, 0, -amount],
  };

  return movements[movement];
}

var posHorizontal = 0;
var depth = 0;
var aim = 0;

input.forEach((singleMove) => {
  var parsedInput = singleMove.split(" ");
  var parsedMove = parseMovement2(parsedInput[0], parseInt(parsedInput[1]));
  posHorizontal += parsedMove[0];
  depth += parsedMove[1];
  aim += parsedMove[2];
});

var totalAimedMoved = posHorizontal * depth;
// console.log("Part 2 answer is: " + totalAimedMoved);

export { totalMove, totalAimedMoved };
