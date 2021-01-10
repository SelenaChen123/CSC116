# CSC116: Lab 05 Journal - Parameters & Return Values

Names: Selena Chen and Ayushi Verma

## MyMath Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

- Find the smallest value of 3 given numbers.
- Find the largest value of 3 given numbers.
- Find the average value of 3 given numbers.

What is already known about the problem?

- We can use the min, max, and average methods.

What questions do you have about the problem?

- How do we find the min and max of 3 values when the min and max Math methods only compare 2 values?

What knowledge concepts from pre-lab would help you solve this problem?

- How to use the Math class
- What paramaters are and how to use them
- What return values are and how to use them

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

- Use the min method to compare 2 values and return the smallest of the 2.
- Store the smallest value in a separate variable and use the min method again to compare the stored value to the last value.
- Return the smallest value.
- Use the max method to compare 2 values and return the largest of the 2.
- Store the largest value in a separate variable and use the max method again to compare the stored value to the last value.
- Return the largest value.
- Add the 3 values and divide by 3 to get the average value.

## MyMath Reflection (***After*** writing code)

How well did your code address the requirements of this exercise? 

- Our code addressed all of the requirements.

How did you apply the pre-lab concepts in this exercise? 

- We applied return statements.
- We applied the Math class.
- We applied parameters.

What are some new insights that you learned from this exercise? 

- How to build on the methods in the Math class.

Estimate how much time (minutes) you spent on this exercise.

- 20 min

## MyAreaCalculations Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

- Find the area of a triangle given three sides
- Find the surface area of a cylinder given the radius

What is already known about the problem?

- The formulas for finding area of a triangle and surface area of a cylinder

What questions do you have about the problem?

- What Math methods we can apply to translate the formulas into a program the computer can read.

What knowledge concepts from pre-lab would help you solve this problem?

- How to use and apply Math methods
- How to use and apply parameters
- How to use and apply return values

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

- Triangle Area: We need to determine the s value for the area formula first, so we take the sum of the three sides then divide by two.  Next, we take the value of s and recreate the formula using the Math square root method. This should give us the area.
- Cylinder Surface Area: We will create a method that takes the radius and height parameters to output the surface area.  We will be using the pi method in the Math Class.

## MyAreaCalculations Reflection (***After*** writing code)

How well did your code address the requirements of this exercise? 

- Our code addressed all of the requirements.

How did you apply the pre-lab concepts in this exercise? 

- We applied return statements.
- We applied the Math class.
- We applied parameters.

What are some new insights that you learned from this exercise? 

- How to translate mathematical formulas into code that the computer can recognize.

Estimate how much time (minutes) you spent on this exercise.

- 10 min

## Grades Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

- Program named Grades
- Method named grade that accepts an integer parameter from 0 to 100 and returns the course grade on the 4.0 scale.
- Main method with the tests of the grade method

What is already known about the problem?

- What scores correspond to what grades on the 4.0 grading scale

What questions do you have about the problem?

- How to create a formula for converting scores to grades.

What knowledge concepts from pre-lab would help you solve this problem?

- How to use and apply parameters
- How to use and apply return values

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

- Subtract the score from 100, then divide by 10 and add 4.0 to convert the score to a grade.

### Sharing and Extending
To help you consider alternative perspectives, share and discuss your initial analysis and solution plan with another group that you will be paired with.

- Shared with Group 11

### Final Planning
After sharing ideas, what changes would you make to enhance your solution plan?  

- None

## Grades Reflection (***After*** writing code)

How well did your code address the requirements of this exercise? 

- Our code addressed all of the requirements.

How did you apply the pre-lab concepts in this exercise? 

- We applied return statements.
- We applied parameters.

What are some new insights that you learned from this exercise? 

- How to use a for loop instead of an if statement

Estimate how much time (minutes) you spent on this exercise.

- 30 min
