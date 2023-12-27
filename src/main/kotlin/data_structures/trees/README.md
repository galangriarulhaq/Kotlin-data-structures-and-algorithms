# Tree Data Structure in Kotlin

This repository contains a simple implementation of a tree data structure in Kotlin. Trees are hierarchical data structures that consist of nodes connected by edges. In this implementation, we focus on a binary tree.

## Binary Tree Implementation

The binary tree is a tree data structure in which each node has at most two children, referred to as the left child and the right child.

### Features

- **Node**: The basic building block of the tree.
- **Insertion**: Add a new element to the tree.
- **Traversal**: Traverse the tree in different orders (e.g., inorder, preorder, postorder).
- **Search**: Find a specific element in the tree.
- **Deletion**: Remove a specific element from the tree.

### Usage

To use the binary tree, you can create an instance of the `BinaryTree` class and perform various operations:

```kotlin
// Create a binary tree
val tree = BinaryTree<Int>()

// Insert elements
tree.insert(5)
tree.insert(3)
tree.insert(7)
tree.insert(2)
tree.insert(4)
tree.insert(6)
tree.insert(8)

// Traverse the tree (inorder)
println("Inorder Traversal:")
tree.inorderTraversal { println(it) }

// Search for an element
val searchResult = tree.search(4)
println("Element 4 found: $searchResult")

// Delete an element
tree.delete(7)
```

## Structure
- **BinaryTree** : The main class representing the binary tree.
- **TreeNode** : The node class containing the data and references to the left and right children.