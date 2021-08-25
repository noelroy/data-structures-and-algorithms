# Big O Notation

* Measures how the time taken increases as the input size is increased.
* Analysis of algorithm is done to mesure the performace of it.
* Highly efficient algorithms can be easily scaled.

Good code is :
1. Readable
2. Uses less memory
3. Fast

## Rules to calculate Big O
1. Take Worst Case

   Eg : For an algorithm to search an array, assume that the element to find it at the end of the array.
2. Remove Constants

   Ignore statements and loops that run constant time.
3. Use different terms for different input

   Eg : If the algorithm takes two array inputs and loops through the 2 array then Big O will be __m + n__.
4. Drop non dominants

   Eg : If the algorithm has a simple loop and a nested loop in consecutive lines, then the simple loop can be ignored.
   


## Analysis of Loops

1. O(1) : Constant

   No loops, recursion of call to non-constant time functions. Also if the loop/recursion runs constant **c** times.
2. O(log(n)) : Logrithmic

   Contains a loop and the loop variable is multipled/divided by a constant value.  
   Eg : Usually for searching algorithms on sorted arrays
3. O(n) : Linear

   Contains a loop and the loop variable is incremented/decremented by a constant value.
4. O(n*log(n)) : Log Linear

   Eg : Usually for sorting algorithms
5. O(n^c) :

   Nested loops and **c** represents the number of inner loops.
6. O(n!) : Factorial

   Loop for every element

For more details check [Big O cheatsheet](https://www.bigocheatsheet.com/)

## Space complexity

__Heap__ : Contains all declared variables.  
__Stack__ : Used mainly in function calls.