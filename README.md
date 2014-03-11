List Evaluation for runtime time complexity (Array List vs Linked List)
==========================

The the speed differences between Array/Vector and Linked List in java. This was inspired by a presentation by Bjarne Stroustrup.


https://www.youtube.com/watch?v=YQs6IC-vgmo


This program will test the removal of elements for different places within the data structures. The result of the tests are the amount of time it takes the two structures to perform the operations clearing the entire structure.

These test illustrate the differences in performance when using the two data structures when remove operations are required. 

Example output:

```
Array
                Back (Size -1)           Front (0)    Middle (Size /2)  Quarter (Size / 4)
2000                         0                   1                   0                   0
10000                        1                   5                   3                   4
50000                        1                 165                  83                 121
250000                       9                5915                2467                4042


Linked
                Back (Size -1)           Front (0)    Middle (Size /2)  Quarter (Size / 4)
2000                         1                   0                   1                   1
10000                        0                   0                  41                  19
50000                        8                   1                1031                 471
250000                      13                   6               26214               11945
```
