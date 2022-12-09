import { input, testInput, testInput2 } from "./input.js";

const yearNum = 2022;
const dayNum = 9;

function formatInput(input) {
  var inputF = [];
  var linesOfInput = input.split("\n");
  linesOfInput.forEach((line) => {
    var lineF = [];
    lineF.push(line.split(" ")[0]);
    lineF.push(parseInt(line.split(" ")[1]));
    inputF.push(lineF);
  });

  return inputF;
}

const inputF = formatInput(input);
const testInputF = formatInput(testInput);
const testInput2F = formatInput(testInput2);

// ===== Part 1 =====

function directionToMove(directionChar) {
  var directionParse = {
    U: [0, 1],
    D: [0, -1],
    L: [-1, 0],
    R: [1, 0],
  };

  return directionParse[directionChar];
}

function directionToFollowWithTail(
  headCurrentX,
  headCurrentY,
  tailCurrentX,
  tailCurrentY
) {
  if (headCurrentX == tailCurrentX && headCurrentY == tailCurrentY)
    return [0, 0];

  if (
    Math.abs(headCurrentX - tailCurrentX) > 1 ||
    Math.abs(headCurrentY - tailCurrentY) > 1
  ) {
    var dirX = 0;
    var dirY = 0;
    if (headCurrentX != tailCurrentX) {
      dirX =
        (headCurrentX - tailCurrentX) / Math.abs(headCurrentX - tailCurrentX);
    }

    if (headCurrentY != tailCurrentY) {
      dirY =
        (headCurrentY - tailCurrentY) / Math.abs(headCurrentY - tailCurrentY);
    }

    return [dirX, dirY];
  } else {
    return [0, 0];
  }
}

function multiDimensionalUnique(arr) {
  var uniques = [];
  var itemsFound = {};
  for (var i = 0, l = arr.length; i < l; i++) {
    var stringified = JSON.stringify(arr[i]);
    if (itemsFound[stringified]) {
      continue;
    }
    uniques.push(arr[i]);
    itemsFound[stringified] = true;
  }
  return uniques;
}

function simulate(directions, headPos, tailPos) {
  var listOfTailVisitedPos = [[0, 0]];

  var currentHeadPos = headPos;
  var currentTailPos = tailPos;
  directions.forEach((direction) => {
    for (var i = 0; i < direction[1]; i++) {
      var headToMove = directionToMove(direction[0]);
      currentHeadPos = [
        currentHeadPos[0] + headToMove[0],
        currentHeadPos[1] + headToMove[1],
      ];

      var tailToMove = directionToFollowWithTail(
        currentHeadPos[0],
        currentHeadPos[1],
        currentTailPos[0],
        currentTailPos[1]
      );
      currentTailPos = [
        currentTailPos[0] + tailToMove[0],
        currentTailPos[1] + tailToMove[1],
      ];

      listOfTailVisitedPos.push([currentTailPos[0], currentTailPos[1]]);
    }
  });

  listOfTailVisitedPos = multiDimensionalUnique(listOfTailVisitedPos);
  return listOfTailVisitedPos.length;
}

var headStartingPos = [0, 0];
var tailStartingPos = [0, 0];
var part1Answer = simulate(inputF, headStartingPos, tailStartingPos);
console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function debugStep(direction, knotPos) {
  console.log("=== " + direction + " ===");
  for (var knot = 0; knot < knotPos.length; knot++) {
    console.log(knot + ": " + knotPos[knot]);
  }
}

function debug2(direction, prevPos, headPos, tailPos) {
  console.log(direction + ": " + prevPos + " " + headPos + " " + tailPos);
}

function simulate2(directions, knotsPosition) {
  var listOfTailVisitedPos = [[0, 0]];
  var currentKnotsPos = [];
  knotsPosition.forEach((knotPos) => {
    currentKnotsPos.push([knotPos[0], knotPos[1]]);
  });
  var prevHeadPos = 0;
  var currentHeadPos = currentKnotsPos[0];
  var currentTailPos = currentKnotsPos[1];

  directions.forEach((direction) => {
    for (var i = 0; i < direction[1]; i++) {
      // Find where the head needs to move to
      var headToMove = directionToMove(direction[0]);
      // Move the head of the rope
      currentKnotsPos[0] = [
        currentKnotsPos[0][0] + headToMove[0],
        currentKnotsPos[0][1] + headToMove[1],
      ];

      for (var knot = 2; knot < currentKnotsPos.length; knot++) {
        prevHeadPos = currentKnotsPos[knot - 2];
        currentHeadPos = currentKnotsPos[knot - 1];
        currentTailPos = currentKnotsPos[knot];

        var currentHeadToMove = directionToFollowWithTail(
          prevHeadPos[0],
          prevHeadPos[1],
          currentHeadPos[0],
          currentHeadPos[1]
        );
        currentKnotsPos[knot - 1] = [
          currentHeadPos[0] + currentHeadToMove[0],
          currentHeadPos[1] + currentHeadToMove[1],
        ];

        var currentTailToMove = directionToFollowWithTail(
          currentHeadPos[0],
          currentHeadPos[1],
          currentTailPos[0],
          currentTailPos[1]
        );
        currentKnotsPos[knot] = [
          currentTailPos[0] + currentTailToMove[0],
          currentTailPos[1] + currentTailToMove[1],
        ];

        if (knot == currentKnotsPos.length - 1) {
          listOfTailVisitedPos.push([currentTailPos[0], currentTailPos[1]]);
          debug2(direction, prevHeadPos, currentHeadPos, currentTailPos);
        }
      }
    }
    // debugStep(direction, currentKnotsPos);
  });

  listOfTailVisitedPos = multiDimensionalUnique(listOfTailVisitedPos);
  //   console.log(listOfTailVisitedPos);
  return listOfTailVisitedPos.length;
}

var knotsStartingPos = [];
var numberOfKnots = 10;
for (var i = 0; i < numberOfKnots; i++) knotsStartingPos.push([0, 0]);

var part2Answer = simulate2(testInput2F, knotsStartingPos);
console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
