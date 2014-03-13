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
               Back (Suze - 1)           Front (0)    Middle (Size /2)  Quarter (Size / 4)
2000                         0                   0                   0                   1
5000                         0                   0                   2                   2
10000                        0                   9                   5                   2
25000                        0                  91                  46                  65
50000                        1                 389                 202                 276
125000                       2                2602                1303                1787
250000                       3               10688                5744                7600
625000                       7               66940               36756               48189
1250000                     25              272536              130842              210395


Linked
               Back (Suze - 1)           Front (0)    Middle (Size /2)  Quarter (Size / 4)
2000                         0                   0                   2                   6
5000                         0                   1                  10                   0
10000                        1                   0                  41                  30
25000                        1                   0                 267                  87
50000                        1                   1                1125                 414
125000                       2                   1                7140                2664
250000                       3                   3               29213               10586
625000                       9                   5              233557               66277
1250000                     24                  15             1313739              265900
```
