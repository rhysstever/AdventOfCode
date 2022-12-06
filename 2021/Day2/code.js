import { input } from "./input.js";

const yearNum = 2021;
const dayNum = 2;

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
  
  var part1Answer = position[0] * position[1];
  // console.log("Part 1 answer is: " + part1Answer);
  
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
  
  var part2Answer = posHorizontal * depth;
  // console.log("Part 2 answer is: " + part2Answer);  

export { yearNum, dayNum, part1Answer, part2Answer };
