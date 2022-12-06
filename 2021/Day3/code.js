import { input } from "./input.js";

const yearNum = 2021;
const dayNum = 3;

// ===== Part 1 =====

var gammaRate = 0;
var epsilonRate = 0;

for (var place = 0; place < input[0].split("").length; place++) {
  var zerosCount = 0;
  var onesCount = 0;
  for (var i = 0; i < input.length; i++) {
    if (parseInt(input[i].split("")[place]) == 0) zerosCount++;
    else onesCount++;
  }

  if (place == 0) {
    if (zerosCount > onesCount) {
      gammaRate = "0";
      epsilonRate = "1";
    } else {
      gammaRate = "1";
      epsilonRate = "0";
    }
  } else {
    if (zerosCount > onesCount) {
      gammaRate += "0";
      epsilonRate += "1";
    } else {
      gammaRate += "1";
      epsilonRate += "0";
    }
  }
}

var part1Answer = parseInt(gammaRate, 2) * parseInt(epsilonRate, 2);
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function getCommonBit(nums, place, getMostCommon) {
  var zeroBitCount = 0;
  var oneBitCount = 0;

  for (var i = 0; i < nums.length; i++) {
    if (parseInt(nums[i].split("")[place]) == 0) zeroBitCount++;
    else oneBitCount++;
  }

  var returningNum = zeroBitCount > oneBitCount ? 0 : 1;
  if (getMostCommon) return returningNum;
  else return returningNum == 1 ? 0 : 1;
}

function findRating(isSearchingForMostCommonBit) {
  var remainingBins = input;
  var placeCount = 0;
  while (remainingBins.length > 1) {
    remainingBins = remainingBins.filter(
      (bin) =>
        bin.split("")[placeCount] ==
        getCommonBit(remainingBins, placeCount, isSearchingForMostCommonBit)
    );
    placeCount++;
  }
  return parseInt(remainingBins[0], 2);
}

var part2Answer = findRating(true) * findRating(false);
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
