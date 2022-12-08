import { input } from "./input.js";
import { sortLowestToHighest } from "../../2021/Day6/code.js";

const yearNum = 2022;
const dayNum = 7;

const inputF = input.split("\n");

// ===== Part 1 =====

function createFileStructure(input) {
  var root = createDir(input[0]);
  var currentNode = root;
  input.forEach((inputLine) => {
    // Create new dir as a child of the current dir
    if (inputLine.includes("dir ")) {
      var newNode = createDir(inputLine);
      currentNode.children.push(newNode);
      newNode.parent = currentNode;
    }
    // Change current dir
    else if (inputLine.includes("$ cd ")) {
      if (inputLine == "$ cd ..") currentNode = currentNode.parent;
      else if (inputLine == "$ cd /") currentNode = root;
      else {
        var childNodeName = inputLine.substring("$ cd ".length);
        currentNode.children.forEach((child) => {
          if (child.name == childNodeName) {
            currentNode = child;
          }
        });
      }
    }
    // Display current dir
    else if (inputLine.includes("$ ls")) {
    }
    // Create new file
    else {
      var newFile = createFile(inputLine);
      currentNode.children.push(newFile);
      newFile.parent = currentNode;
    }
  });
  return root;
}

function createDir(strLine) {
  var name = "";
  if (strLine.includes("/")) name = "/";
  else name = strLine.substring("dir ".length);
  return {
    name: name,
    parent: "",
    children: [],
    text: name + " (dir)",
  };
}

function createFile(strLine) {
  var arr = strLine.split(" ");
  return {
    name: arr[1],
    parent: "",
    size: parseInt(arr[0]),
    text: arr[1] + " (file, size=" + arr[0] + ")",
  };
}

function sumTotalSize(dir, mainArr) {
  var sum = 0;
  dir.children.forEach((child) => {
    if (child.hasOwnProperty("size")) sum += child.size;
    else sum += sumTotalSize(child, mainArr);
  });
  mainArr.push(sum);
  return sum;
}

function getDirSizeArrFromSuming(root) {
  var arr = [];
  root.children.forEach((child) => {
    if (!child.hasOwnProperty("size")) {
      sumTotalSize(child, arr);
    }
  });
  return arr;
}

function findLimitedSizeSum(root, maxSize) {
  var mainArr = getDirSizeArrFromSuming(root);

  var limitedSum = 0;
  mainArr
    .filter((num) => num < maxSize)
    .forEach((num) => {
      limitedSum += num;
    });

  return limitedSum;
}

var root = createFileStructure(inputF);
var maxSize = 100000;
var part1Answer = findLimitedSizeSum(root, maxSize);
// console.log("Part 1 answer is: " + part1Answer);

// ===== Part 2 =====

function findSmallestDirToCreateEnoughSpace(
  root,
  totalSystemSpace,
  spaceNeeded
) {
  var dirSizeArr = getDirSizeArrFromSuming(root);
  var sizeOfRootDir = sumTotalSize(root, []);
  dirSizeArr.push(sizeOfRootDir);
  var unusedSpace = totalSystemSpace - sizeOfRootDir;

  dirSizeArr = dirSizeArr
    .filter((dirSize) => unusedSpace + dirSize > spaceNeeded)
    .sort(sortLowestToHighest);

  return dirSizeArr[0];
}

var totalSpace = 70000000;
var spaceNeeded = 30000000;
var part2Answer = findSmallestDirToCreateEnoughSpace(
  root,
  totalSpace,
  spaceNeeded
);
// console.log("Part 2 answer is: " + part2Answer);

export { yearNum, dayNum, part1Answer, part2Answer };
