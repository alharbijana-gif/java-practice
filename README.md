# Java Practice

Practice implementations of core concepts from my Data Structures & Algorithms (Java) and Object-Oriented Programming (Java) courses.
These are study exercises written to review the material, not full course projects.

## Contents

### `src/dsa` - data structures and algorithms
| File | Topic |
|---|---|
| `MyLinkedList.java` | Generic singly linked list (add, remove, reverse) |
| `ArrayStack.java` | Resizable array stack, plus balanced-brackets checker |
| `CircularQueue.java` | Fixed-capacity circular queue |
| `BinarySearchTree.java` | Insert, search, delete, in-order traversal, height |
| `Sorting.java` | Bubble, insertion, merge and quick sort, plus binary search |
| `DsaDemo.java` | Runs a check for each of the above |

### `src/oop` - object-oriented programming
| File | Concept |
|---|---|
| `Shape`, `Circle`, `Rectangle`, `Triangle` | Abstract classes, inheritance, polymorphism, `Comparable` |
| `BankAccount`, `SavingsAccount`, `CheckingAccount` | Encapsulation, method overriding |
| `InsufficientFundsException` | Custom checked exception |
| `OopDemo.java` | Demo of all of the above |

## How to run
```bash
javac -d out $(find src -name "*.java")
java -cp out dsa.DsaDemo
java -cp out oop.OopDemo
```

## Complexity notes
- Bubble / insertion sort: O(n^2). Merge sort: O(n log n) with O(n) extra space. Quick sort: O(n log n) average.
- Binary search: O(log n). BST operations: O(h), where h is the tree height.
