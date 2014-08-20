List Evaluation for runtime time complexity (Array List vs Linked List)
==========================

The the speed differences between Array/Vector and Linked List in java. This was inspired by a presentation by Bjarne Stroustrup.

Presentation: https://www.youtube.com/watch?v=YQs6IC-vgmo

Additional Resource: http://www.codeproject.com/Articles/340797/Number-crunching-Why-you-should-never-ever-EVER-us#TOC_IRL

This program will test the removal of elements from different locations within the data structures. The result of the tests are the 
amount of time it takes the two structures to perform the operations clearing the entire structure.

These tests illustrate the differences in performance when using the two data structures with the requirement of removing elements 
at a given location for a given size. 

In order to represent the nature of the problem, specific locations were chosen. The middle (size / 1) was chosen as it should be 
worst case for linked list. This is true as it will represent the most navigation (traversing from node to node) through the data 
structure due to the characteristic of being able to navigate from the front or back (if the index is greater or less than the 
mid point) as it is doubly linked.

Example output:

```
Array
               Back (Size - 1)           Front (0)    Middle (Size /2)  Quarter (Size / 4)
10000                     0.22                3.12                0.40                0.56
50000                     0.37               14.90                1.94                2.73
250000                    0.95               73.37               12.72               19.63
1250000                   4.02              378.94               63.56              113.48
3125000                   9.58              955.31              492.66              443.77
15625000                 47.34             4819.21             2511.40             2418.15
78125000                282.68            23970.46            12551.41            12157.82
150625000               571.52            46731.59            23930.46            23689.14


Linked
               Back (Size - 1)           Front (0)    Middle (Size /2)  Quarter (Size / 4)
10000                     0.42                0.16                4.28                1.98
50000                     0.62                0.36               21.33               10.00
250000                    1.43                1.34              116.64               49.92
1250000                   6.12                6.24              690.70              369.35
3125000                  14.93               14.68             1731.15              897.77
15625000                 73.61               73.92             8669.99             3970.80
78125000                365.42              373.59            43586.36            19589.83
150625000              1234.24              703.02            82896.18            38248.57
```
