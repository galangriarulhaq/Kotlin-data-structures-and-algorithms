# Kotlin Queue Implementation

Implementation of the Queue data structure in the Kotlin programming language.

## Description

Queue is a linear data structure that follows the FIFO (First-In-First-Out) principle, where the element that is inserted first will be the first one to be removed. Queues are commonly used for task scheduling, managing queues, and many other applications.

This project provides a simple implementation of a Queue using the Kotlin programming language. The implementation includes basic operations such as adding elements to the queue (enqueue), removing elements from the queue (dequeue), and checking if the queue is empty.

## How to Use

1. Clone this repository into your Kotlin project.

```bash
git clone https://github.com/Galang211/Kotlin-data-structures-and-algorithms/tree/master/src/main/kotlin/data_structures/queues
```

## Example Use

```kotlin
fun main() {
    val myQueue = Queue<String>()

    myQueue.enqueue("A")
    myQueue.enqueue("B")
    myQueue.enqueue("C")

    println("First element: ${myQueue.peek()}")

    while (!myQueue.isEmpty()) {
        println("Removed element: ${myQueue.dequeue()}")
    }
}
```

## Contributions
If you would like to contribute to this project, please open issues or create pull requests.