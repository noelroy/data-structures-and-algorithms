# Arrays

## Time Complexity

* lookup : O(1)
* push   : O(1) - can be O(n) in case of dynamic arrays when the array expands
* insert : O(n)
* delete : O(n)

## Advantages : 
1. Allow random access of elements ( fast lookups )
2. Better cache locality

   As arrays are in continuous memory locations, so a lot of them will be moved into cache on first access. This makes it easy to access other elements in future and reduce cache miss.

## Disadvantages :
1. Slow insert and delete
2. Fixed size in case of static array

## JavaScript array operations

1. push - add at the end
2. pop - remove from end
3. unshift - add at the start
4. splice - add/remove from middle

## Tips
1. In interviews consider sring questions as array questions

