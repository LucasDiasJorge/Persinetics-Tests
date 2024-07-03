## Why ASCII operations ?

While string operations in Java are generally optimized, they still involve overhead related to memory allocation and garbage collection for strings.

## Practical Performance Considerations:

### Memory Efficiency: 
Using integers (ASCII values) is more memory-efficient compared to strings, especially when dealing with a large number of nodes.


### CPU Efficiency: 
Integer comparisons and hash set operations with integers are typically faster than equivalent operations with strings due to reduced overhead and simpler computations.
