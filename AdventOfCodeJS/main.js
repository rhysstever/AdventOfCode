// Year 2021 imports
import {
  part1Answer as answer2021Day1Part1,
  part2Answer as answer2021Day1Part2,
} from "./2021/Day1/code.js";
import {
  part1Answer as answer2021Day2Part1,
  part2Answer as answer2021Day2Part2,
} from "./2021/Day2/code.js";
import {
  part1Answer as answer2021Day3Part1,
  part2Answer as answer2021Day3Part2,
} from "./2021/Day3/code.js";
import {
  part1Answer as answer2021Day4Part1,
  part2Answer as answer2021Day4Part2,
} from "./2021/Day4/code.js";
import {
  part1Answer as answer2021Day5Part1,
  part2Answer as answer2021Day5Part2,
} from "./2021/Day5/code.js";

// Year 2022 imports
import {
  part1Answer as answer2022Day1Part1,
  part2Answer as answer2022Day1Part2,
} from "./2022/Day1/code.js";
import {
  part1Answer as answer2022Day2Part1,
  part2Answer as answer2022Day2Part2,
} from "./2022/Day2/code.js";
import {
  part1Answer as answer2022Day3Part1,
  part2Answer as answer2022Day3Part2,
} from "./2022/Day3/code.js";
import {
  part1Answer as answer2022Day4Part1,
  part2Answer as answer2022Day4Part2,
} from "./2022/Day4/code.js";
import {
  part1Answer as answer2022Day5Part1,
  part2Answer as answer2022Day5Part2,
} from "./2022/Day5/code.js";
import {
  part1Answer as answer2022Day6Part1,
  part2Answer as answer2022Day6Part2,
} from "./2022/Day6/code.js";
import {
  part1Answer as answer2022Day7Part1,
  part2Answer as answer2022Day7Part2,
} from "./2022/Day7/code.js";
import {
  part1Answer as answer2022Day8Part1,
  part2Answer as answer2022Day8Part2,
} from "./2022/Day8/code.js";

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
    [answer2022Day6Part1, answer2022Day6Part2],
    [answer2022Day7Part1, answer2022Day7Part2],
    [answer2022Day8Part1, answer2022Day8Part2],
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
