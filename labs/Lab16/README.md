# CSC116: Lab 16 Journal - Array Basics

Names: Selena Chen & Ayushi Verma

## Exam Score Processor (***Before*** writing code)

[Programming Scenario](CSC116-Lab16-specific.md) 

**Do not start writing code until you have received the generic problem and hints, which will specify the methods to write and provide test cases.**

### Initial Planning - Problem Analysis

What are the requirements of this problem?

- We need a method to find  the student with the largest ID who received a given score, such as 85.
- We need a method to find the highest score and the lowest score of the exam.
- We need a method to count the number of students who received a given grade, such as B.

What is already known about the problem?

- We know what our methods need to do.

What questions do you have about the problem?

- None

What knowledge concepts from pre-lab would help you solve this problem?

- How to use arrays.

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. **You should not write out Java code yet.**

#### Task 1 method

- Use a for loop to iterate through each element of the array, from the last element to the first element using the .length method. Then within that for loop, use an if statement to check whether the element at that index is equal to the grade wanted (85), and if it is true, then set a variable equal to that index. Otherwise, the method will return -1 to indicate that no student got that grade.

#### Task 2 method

- Initialize a variable max to 0 and a variable min to 100. Use a for each loop to iterate through each element of the array, from the first element to the last element. Then within that for each loop, use one if statement to check whether the current element is greater than the max, and if so, make that the new max. Do the same for the min, but check whether the current element is less than the min.

#### Task 3 method

- Create multiple methods to count the number of different letter grades. Within each method, we would initialize a count variable to 0 and then use a for each loop to iterate through each element of the array from the first element to the last element. Within the for each loop, there would be an if statement to check whether the element is within the respective range (i.e. 90-100 for A, 80-89 for B, etc.). If it is, increment the count variable, and then return the count at the very end of the method.

#### Other methods

- Main method
- Scanner method

### Sharing and Extending

* To help you consider alternative perspectives, share and discuss your initial analysis and solution plan with another group.
* **Let Dr. Schmidt know when you have reached this point. She will give you starter code and the generic problem.**
* To make your solution plan flexible for similar types of programming scenarios, read the [generic problem and programming hints](CSC116-Lab16-generic.md) provided.

### Final Planning

After sharing ideas and reading the generic problem and hints, what changes would you make to enhance your solution plan?  A good solution plan should not only solve the given programming scenario, but also address the generic problem underlying that scenario.

- None

## Reflection (***After*** writing code)

How well did your code address the requirements of this exercise? 

- Our code addressed all of the requirements.

How did you apply the pre-lab concepts in this exercise? 

- We used arrays.

What are some new insights that you learned from this exercise? 

- We learned how to properly use arrays.

Estimate how much time (minutes) you spent on this exercise.

- 40 min
