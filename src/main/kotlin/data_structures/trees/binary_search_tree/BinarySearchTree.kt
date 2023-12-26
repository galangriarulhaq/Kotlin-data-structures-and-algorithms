package data_structures.trees.binary_search_tree

import java.util.*

/**
 * Simple implementation of a Binary Search Tree (BST) data structure.
 *
 * @property root Points to the root node of the binary search tree.
 */
class BinarySearchTree {
    var root: Node? = null

    /**
     * Inserts a new node with the given value into the binary search tree.
     *
     * @param value The value to be inserted into the binary search tree.
     */
    fun insert(value: Int) {
        val newNode = Node(value)
        if (this.root == null) {
            // If the tree is empty, set the new node as the root.
            this.root = newNode
        } else {
            var current = this.root
            while (true) {
                // Traverse to the right subtree if the current node value is less than the new value.
                if (current!!.value < value) {
                    if (current.right != null) {
                        current = current.right
                    } else {
                        current.right = newNode
                        break
                    }
                } else {
                    // Traverse to the left subtree if the current node value is greater than or equal to the new value.
                    if (current.left != null) {
                        current = current.left
                    } else {
                        current.left = newNode
                        break
                    }
                }
            }
        }
    }

    /**
     * Searches for a node with the given value in the binary search tree and returns true if found, otherwise false.
     *
     * @param value The value to be searched in the binary search tree.
     * @return True if the value is found, otherwise false.
     */
    fun lookup(value: Int): Boolean {
        var current = this.root
        while (current != null) {
            current = when {
                current.value > value -> {
                    current.left
                }
                current.value < value -> {
                    current.right
                }
                else -> {
                    return true
                }
            }
        }
        return false
    }

    /**
     * Removes a node with the given value from the binary search tree.
     *
     * @param value The value of the node to be removed.
     */
    fun remove(value: Int) {
        if (this.root == null) {
            return
        }
        var current = this.root
        var parentNode: Node? = null

        // Traverse the tree to find the node to be removed.
        while (current != null) {
            when {
                value < current.value -> {
                    // Go left if the value is smaller.
                    parentNode = current
                    current = current.left
                }
                value > current.value -> {
                    // Go right if the value is greater.
                    parentNode = current
                    current = current.right
                }
                else -> {
                    // Node to be removed is found.

                    // Option 1: No right child.
                    if (current.right == null) {
                        // If parentNode is null, the root node is to be removed.
                        if (parentNode == null) {
                            this.root = current.left
                        } else {
                            // Make the left child of the current node a child of its parent.
                            if (current.value < parentNode.value) {
                                parentNode.left = current.left
                            } else if (current.value > parentNode.value) {
                                parentNode.right = current.left
                            }
                        }
                    } else if (current.right!!.left == null) {
                        // Option 2: Right child has no left child.
                        if (parentNode == null) {
                            this.root = current.right
                        } else {
                            // Make the right child of the current node a child of its parent.
                            if (current.value < parentNode.value) {
                                parentNode.left = current.right
                            } else if (current.value > parentNode.value) {
                                parentNode.right = current.right
                            }
                        }
                    } else {
                        // Option 3: Right child has left child.
                        if (parentNode == null) {
                            // Save references to the left and right nodes of the root.
                            val leftNode = this.root!!.left
                            val rightNode = this.root!!.right

                            // Make the leftmost node of the right subtree the new root.
                            this.root = current.right!!.left

                            // Set the saved references of left and right nodes of the root.
                            rightNode!!.left = rightNode.left!!.right
                            this.root!!.left = leftNode
                            this.root!!.right = rightNode
                        } else {
                            // Make the leftmost node of the right subtree a child of its parent.
                            if (current.value < parentNode.value) {
                                parentNode.left = current.right!!.left
                            } else if (current.value > parentNode.value) {
                                parentNode.right = current.right!!.left
                            }
                        }
                    }
                    return
                }
            }
        }
    }

    /**
     * Performs breadth-first search on the binary search tree and returns the values of the nodes in an ArrayList.
     *
     * @return An ArrayList containing the values of the nodes in breadth-first order.
     */
    fun breadthFirstSearch(): ArrayList<Int> {
        var currentNode = this.root
        val resultArray = ArrayList<Int>()
        val queue = ArrayList<Node?>()
        queue.add(currentNode)

        // Traverse the tree in breadth-first order using a queue.
        while (queue.size > 0) {
            currentNode = queue.removeAt(0)
            resultArray.add(currentNode!!.value)
            if (currentNode.left != null) {
                queue.add(currentNode.left)
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right)
            }
        }
        return resultArray
    }

    /**
     * Helper function for recursive breadth-first search.
     *
     * @param queue The queue used for recursive breadth-first search.
     * @param resultArray The ArrayList to store the values of the nodes in breadth-first order.
     * @return An ArrayList containing the values of the nodes in breadth-first order.
     */
    fun breadthFirstSearchRecursive(
        queue: ArrayList<Node?>,
        resultArray: ArrayList<Int>
    ): ArrayList<Int> {
        // Base case: If the queue is empty, return the resultArray.
        if (queue.size == 0) {
            return resultArray
        }

        // Remove the first node from the queue and process it.
        val currentNode = queue.removeAt(0)
        resultArray.add(currentNode!!.value)

        // Add the left and right children of the current node to the queue if they exist.
        if (currentNode.left != null) {
            queue.add(currentNode.left)
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right)
        }

        // Continue the recursive call with the updated queue and resultArray.
        return breadthFirstSearchRecursive(queue, resultArray)
    }

    /**
     * Performs depth-first search (in-order) on the binary search tree and returns the values of the nodes in an ArrayList.
     *
     * @return An ArrayList containing the values of the nodes in in-order depth-first search order.
     */
    fun DFSInOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traverseInOrder(this.root, answer)
    }

    /**
     * Performs depth-first search (pre-order) on the binary search tree and returns the values of the nodes in an ArrayList.
     *
     * @return An ArrayList containing the values of the nodes in pre-order depth-first search order.
     */
    fun DFSPreOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traversePreOrder(this.root, answer)
    }

    /**
     * Performs depth-first search (post-order) on the binary search tree and returns the values of the nodes in an ArrayList.
     *
     * @return An ArrayList containing the values of the nodes in post-order depth-first search order.
     */
    fun DFSPostOrder(): ArrayList<Int?> {
        val answer = ArrayList<Int?>()
        return traversePostOrder(this.root, answer)
    }

    /**
     * Helper function for in-order traversal during depth-first search.
     *
     * @param node The current node being processed.
     * @param array The ArrayList to store the values of the nodes during in-order traversal.
     * @return An ArrayList containing the values of the nodes in in-order depth-first search order.
     */
    private fun traverseInOrder(node: Node?, array: ArrayList<Int?>): ArrayList<Int?> {
        if (node?.left != null) {
            traverseInOrder(node.left, array)
        }
        array.add(node?.value)
        if (node?.right != null) {
            traverseInOrder(node.right, array)
        }
        return array
    }

    /**
     * Helper function for pre-order traversal during depth-first search.
     *
     * @param node The current node being processed.
     * @param array The ArrayList to store the values of the nodes during pre-order traversal.
     * @return An ArrayList containing the values of the nodes in pre-order depth-first search order.
     */
    private fun traversePreOrder(node: Node?, array: ArrayList<Int?>): ArrayList<Int?> {
        array.add(node?.value)
        if (node?.left != null) {
            traversePreOrder(node.left, array)
        }
        if (node?.right != null) {
            traversePreOrder(node.right, array)
        }
        return array
    }

    /**
     * Helper function for post-order traversal during depth-first search.
     *
     * @param node The current node being processed.
     * @param array The ArrayList to store the values of the nodes during post-order traversal.
     * @return An ArrayList containing the values of the nodes in post-order depth-first search order.
     */
    private fun traversePostOrder(node: Node?, array: ArrayList<Int?>): ArrayList<Int?> {
        if (node?.left != null) {
            traversePostOrder(node.left, array)
        }
        if (node?.right != null) {
            traversePostOrder(node.right, array)
        }
        array.add(node?.value)
        return array
    }
}

fun main() {
    val bst = BinarySearchTree()
    bst.insert(9)
    bst.insert(4)
    bst.insert(6)
    bst.insert(20)
    bst.insert(170)
    bst.insert(15)
    bst.insert(1)
    println("bfs: " + bst.breadthFirstSearch())
    println("look for 20: " + bst.lookup(20))
    val queue = ArrayList<Node?>()
    queue.add(bst.root)
    println("bfs recursive: " + bst.breadthFirstSearchRecursive(queue, ArrayList()))
    println("dfs inOrder: " + bst.DFSInOrder())
    println("dfs preOrder: " + bst.DFSPreOrder())
    println("dfs postOrder: " + bst.DFSPostOrder())
    bst.remove(20)
    println("look for 20 after removing 20: " + bst.lookup(20))
}