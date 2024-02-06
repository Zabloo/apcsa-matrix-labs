# Find the Determinant

## Overview

The determinant is a special number we use to analyze square matrices (i.e. 2D arrays with the same number of rows and columns). You will write a method that calculates the determinant for 2x2 and 3x3 matrices; [use the following page to help you in your calculations](https://www.mathsisfun.com/algebra/matrix-determinant.html).

## Requirements:
- Return the determinant for a 2x2 array of integers.
- Return the determinant for a 3x3 array of integers
- If the array's number of rows does not meet its number of columns, print a message saying "Invalid array" and return 0. 
## For Mastery:
- Write a method that computes the determinant for ANY size array. Hint: It will likely be recursive. Consider writing a method that only does 2x2 arrays.

# Matrix Math

## Overview
Write these methods that will help you practice your understanding of 2D arrays (matrices).

## Scale

Write a method, scale, that takes in two arguments: a 2D array of ints, and a scaling factor. The method should multiply each value in the 2D array by that scaling factor, and return the resultant array.

## Multiply Matrices

Write a method that multiplies two matrices together using the method [shown on this website](https://www.mathsisfun.com/algebra/matrix-multiplying.html). It should take two arguments, each being an array of integers. It should perform repeated multiplication operations as shown on the above website, as well as the attached drawing (see example.draw). The resultant array that is returned will have 

You can assume that the matrices are valid for multiplication, meaning:
- the number of columns of the 1st matrix equal the number of rows of the 2nd matrix, and
- the number of rows of the 1st matrix equal the number of columns of the 2nd matrix

