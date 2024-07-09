# Why ASCII operations ?

While string operations in Java are generally optimized, they still involve overhead related to memory allocation and garbage collection for strings.

## Practical Performance Considerations:

### CPU Efficiency: 

Integer comparisons and hash set operations with integers are typically faster than equivalent operations with strings due to reduced overhead and simpler computations.

### Memory Efficiency: 

Using integers (ASCII values) is more memory-efficient compared to strings, especially when dealing with a large number of nodes.

## Example Memory Comparison

### Single Characteres 

1 - Using int: 4 bytes.

2 - Using String: At least 40 bytes. This includes the character array, the String object overhead, and other metadata.

### Multiple Characters (e.g., "abc"): 

1 - Using int: 3 characters * 4 bytes each = 12 bytes.

2 - Using String: 2 bytes per character * 3 characters + overhead = approximately 46 bytes or more.

### Access Time: 

1 - int: Accessing and manipulating an int is a direct memory operation, which is very fast.

2 - String: Accessing characters within a string involves indexing into the character array and potentially additional overhead due to method calls and bounds checking.

## Operations:

1 - int: Arithmetic operations on int values are very efficient due to direct CPU support.

2 - String: Operations like concatenation, substring, or comparison involve more complex logic and memory management.

## Simplicity

1 - Code Simplicity: Using int for representing ASCII values often leads to simpler and more readable code when the task involves numerical operations or comparisons.Example: Checking if a character is a digit can be done with simple arithmetic when using int.

2 - Reduced Overhead: When dealing with dependencies or comparisons, using int reduces the complexity associated with string manipulation functions.
