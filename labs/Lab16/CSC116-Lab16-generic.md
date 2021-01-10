# Exam Score Processor: Generic Problem and Hints

The following methods should be placed in IntArrayAlgorithms.java (given). You should should use IntArrayAlgorithmsTest.java (given) to test your methods.

## Task 1 - lastIndexOf

**Generic Problem:** Write a method called `lastIndexOf` that accepts an array of integers and an integer value as its parameters and returns the last index at which the value occurs in the array. The method should return -1 if the value is not found. For example, in the array `[74, 85, 102, 99, 101, 85, 56]`, the last index of the value `85` is `5`.

**Output:** Return an int: The last index of the value `85` in `{74, 85, 102, 99, 101, 85, 56}` is `5`.

**Hints:** Describe an algorithm for find the last index at which a given value is found in an array. Consider traversing the array from each end, which  approach would be the most efficient?

## Task 2 - range

**Generic Problem:** Write a method called `range` that returns the range of values in an array of integers. The range is defined as 1 more than the difference between the maximum and minimum values in the array. For example, if an array called `list` contains the values `[36, 12, 25, 19, 46, 31, 22]`, the call of `range(list)` should return `35` (46 - 12 + 1). You may assume that the array has at least one element.

**Output:** Return an int: `The range of {36, 12, 25, 19, 46, 31, 22} is 35.`

**Hints:** Describe an algorithm for finding the maximum and minimum values in an array. As you consider different algorithms, make sure that you do not modify the array (or change the order of elements).

## Task 3 - countInRange

**Generic Problem:** Write a method called `countInRange` that accepts an array of integers, a minimum value, and a maximum value as parameters and returns the count of how many elements from the array fall between the minimum and maximum (inclusive). For example, in the array `[14, 1, 22, 17, 36, 7, –43, 5]`, for minimum value 4 and maximum value 17, there are four elements whose values fall between 4 and 17. You may assume that the minimum is less than or equal to the maximum.

**Output:** Return an int: In the array `{14, 1, 22, 17, 36, 7, -43, 5}`, there are 4 elements whose values fall between 4 and 17.

**Hints:** Describe an algorithm that traverses an array and counts the number of elements in a certain range (inclusive of minimum and maximum value).
