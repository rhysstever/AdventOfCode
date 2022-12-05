// Year 2021 imports
import {
  increases as answer2021Day1Part1,
  sumIncreases as answer2021Day1Part2,
} from "./2021/Day1.js";
import {
  totalMove as answer2021Day2Part1,
  totalAimedMoved as answer2021Day2Part2,
} from "./2021/Day2.js";
import {
  powerConsumption as answer2021Day3Part1,
  lifeSupportRating as answer2021Day3Part2,
} from "./2021/Day3.js";
import {
  bestBoardScore as answer2021Day4Part1,
  worstBoardScore as answer2021Day4Part2,
} from "./2021/Day4.js";
import {
  part1CountOver2 as answer2021Day5Part1,
  part2CountOver2 as answer2021Day5Part2,
} from "./2021/Day5.js";

// Year 2022 imports
import {
  rowMax as answer2022Day1Part1,
  top3RowSums as answer2022Day1Part2,
} from "./2022/Day1.js";
import {
  matchScoreTotal as answer2022Day2Part1,
  matchScoreTotal2 as answer2022Day2Part2,
} from "./2022/Day2.js";
import {
  prioSum as answer2022Day3Part1,
  prioSum2 as answer2022Day3Part2,
} from "./2022/Day3.js";
import {
  subStrCounter1 as answer2022Day4Part1,
  subStrCounter2 as answer2022Day4Part2,
} from "./2022/Day4.js";
import {
  part1Layout as answer2022Day5Part1,
  part2Layout as answer2022Day5Part2,
} from "./2022/Day5.js";

const answers = {
  2021: [
    [answer2021Day1Part1, answer2021Day1Part2],
    [answer2021Day2Part1, answer2021Day2Part2],
    [answer2021Day3Part1, answer2021Day3Part2],
    [answer2021Day4Part1, answer2021Day4Part2],
    [answer2021Day5Part1, answer2021Day5Part2],
  ],
  2022: [
    [answer2022Day1Part1, answer2022Day1Part2],
    [answer2022Day2Part1, answer2022Day2Part2],
    [answer2022Day3Part1, answer2022Day3Part2],
    [answer2022Day4Part1, answer2022Day4Part2],
    [answer2022Day5Part1, answer2022Day5Part2],
  ],
};

function displayDayAnswers(dayNum, answer1, answer2) {
  return "Day " + dayNum + ": Part 1 = " + answer1 + " | Part 2 = " + answer2;
}

for (var year in answers) {
  console.log("=== Year " + year + " ===");
  for (var i = 0; i < answers[year].length; i++) {
    console.log(
      displayDayAnswers(i + 1, answers[year][i][0], answers[year][i][1])
    );
  }
}
