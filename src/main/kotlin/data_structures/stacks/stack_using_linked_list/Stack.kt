package data_structures.stacks.stack_using_linked_list

/**
 * Simple implementation of a stack data structure using linked list.
 *
 * @property top Points to the top node in the stack.
 * @property bottom Points to the bottom node in the stack.
 * @property length Represents the number of elements currently in the stack.
 */
class Stack {
    private var top: Node? = null
    private var bottom: Node? = null
    private var length = 0

    /**
     * Returns the value of the top element in the stack without removing it.
     *
     * @return The value of the top element if the stack is not empty, otherwise null.
     */
    fun peek(): String? {
        return if (length > 0) {
            top?.value
        } else {
            null
        }
    }

    /**
     * Adds an element with the given value to the top of the stack.
     *
     * @param value The value to be added to the stack.
     */
    fun push(value: String?) {
        val newNode = Node(value)
        if (length == 0) {
            top = newNode
            bottom = newNode
        } else {
            newNode.next = top
            top = newNode
        }
        length++
    }

    /**
     * Removes the top element from the stack if it's not empty.
     */
    fun pop() {
        if (length > 0) {
            top = top?.next
            if (length == 1) {
                bottom = null
            }
            length--
        }
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, otherwise false.
     */
    fun isEmpty() = length == 0

    /**
     * Returns the value of the last element in the stack without removing it.
     *
     * @return The value of the last element if the stack is not empty, otherwise null.
     */
    val lastElement: String?
        get() = if (length > 0) {
            bottom?.value
        } else null
}

/*
*  In this implementation, the programme has a Node class that represents a node in a linked list. Each node has data (value)
*  and a reference to the next node. Then, the Stack class has methods like push to add an element to the stack,
*  pop to remove an element from the stack, peek to see the top element without removing it, isEmpty to check if the stack is empty
*
*  In the push method, the programme creates a new node with the given value, and then sets the new node's next reference to the current top node. In the pop method,
*  we replace top with the next node in order to remove the top element from the stack. The isEmpty method checks if top is null*/

fun main() {

    val myStack = Stack()
    myStack.push("Google")
    myStack.push("Dicoding")
    myStack.push("Discord")
    println(myStack.peek())
    myStack.pop()
    println(myStack.isEmpty())
    println(myStack.lastElement)
}