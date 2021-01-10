# CSC116: Lab 18 Journal - Arrays of Objects & Multi-Dimensional Arrays

Names: Selena Chen & Ayushi Verma

## 2-D Array Equality (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

- We need equals2D methods in a TwoArrayEquality class.
- The methods should accept a pair of two-dimensional arrays of integers/Strings as parameters. It return true if the arrays contain the same elements in the same order. If the arrays are not the same length in either dimension, your method should return false.

What is already known about the problem?

- We know what the name of the class and methods should be.
- We know that we can't use the .equals or .deepEquals methods.

What questions do you have about the problem?

- None

What knowledge concepts from pre-lab would help you solve this problem?

- How to create and utilize 2D arrays.

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

- First, check to see if they're the same length. If not, imediately return false.
- Next, in the int equals2D method, we would traverse through both arrays and if the integer at the indexes were not equal throughout the length of the array, then return false. Otherwise return true.
- Do the same for the string equals2D method, but use the charAt method to check whether the characters at both indexes were equal or not.

How will you test each method?

- Using the white box test program.

## 2-D Array Equality (***After*** writing code)

How well did your code address the requirements of this exercise? 

- Our code addressed all the requirements.

How did you apply the pre-lab concepts in this exercise? 

- We used 2D arrays.

What are some new insights that you learned from this exercise? 

- How to use 2D arrays.

Estimate how much time (minutes) you spent on this exercise.

- 30 min

## String Arrays (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

- The isPalindrome method should accept an array of Strings as its argument and returns true if that array is a palindrome (if it reads the same forwards as backwards) and false if not.
- Arrays with zero or one element are considered to be palindromes.

What is already known about the problem?

- We need a program called StringArrays and a method called isPalindrome.

What questions do you have about the problem?

- None

What knowledge concepts from pre-lab would help you solve this problem?

- How to use arrays of objects.

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

- We need a for loop that traverses through the length of the String array, and if each element of the array is not equal to the corresponding element at the end of the array, then return false. Otherwise, return true.

How will you test each method?

- Using the white box test program.

## String Arrays (***After*** writing code)

How well did your code address the requirements of this exercise? 

- Our code addressed all the requirements.

How did you apply the pre-lab concepts in this exercise? 

- We used arrays of objects.

What are some new insights that you learned from this exercise? 

- We learned how to use arrays of objects.

Estimate how much time (minutes) you spent on this exercise.

- 10 min
