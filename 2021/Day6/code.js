import { input } from "./input.js";

const yearNum = 2021;
const dayNum = 6;

// ===== Part 1 =====

function grow1Day(currentPop) {
  var newPop = [];
  var babyPop = [];
  for (var i = 0; i < currentPop.length; i++) {
    if (currentPop[i] == 0) {
      newPop.push(6);
      babyPop.push(8);
    } else {
      newPop.push(currentPop[i] - 1);
    }
  }
  return newPop.concat(babyPop);
}

var part1Pop = input;
for (var i = 0; i < 80; i++) {
  part1Pop = grow1Day(part1Pop);
}

var part1Answer = part1Pop.length;
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function sortLowestToHighest(a, b) {
  if (a > b) {
    return 1;
  }
  if (a < b) {
    return -1;
  }
  return 0;
}

function convertPopToCountOfPop(intArr) {
  var countsArr = [];
  for (var i = 0; i < 9; i++) {
    countsArr.push(0);
  }

  intArr.sort(sortLowestToHighest);

  var numCounter = 0;
  var currentNum = 0;
  for (var i = 0; i < intArr.length; i++) {
    if (intArr[i] == currentNum) numCounter++;
    else {
      countsArr[currentNum] = numCounter;
      currentNum++;
    }
  }

  return countsArr;
}

function smartGrow1Day(truncatedIntArr) {
  var nextDayPopCount = [];
  for (var i = 0; i < 9; i++) {
    nextDayPopCount.push(0);
  }

  for (var i = 0; i < truncatedIntArr.length; i++) {
    var indexCount = truncatedIntArr[i];

    if (i == 0) {
      nextDayPopCount[6] += indexCount;
      nextDayPopCount[8] += indexCount;
    } else {
      nextDayPopCount[i - 1] += indexCount;
    }
  }

  return nextDayPopCount;
}

var endArr = convertPopToCountOfPop(input);
for (var i = 0; i < 80; i++) {
  endArr = smartGrow1Day(endArr);
}

var endPop = 0;
endArr.forEach((index) => {
  endPop += index;
});

// console.log(endPop);
var part2Answer = endPop;

export { yearNum, dayNum, part1Answer, part2Answer, sortLowestToHighest };
