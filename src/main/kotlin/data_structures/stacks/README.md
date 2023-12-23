# Kotlin Stack Data Structure

A simple implementation of a stack data structure in Kotlin.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Stack Overview](#stack-overview)
- [Usage](#usage)
- [Example](#example)
- [Contributing](#contributing)

## Introduction

This project provides a basic implementation of a stack data structure in Kotlin. A stack is a Last In First Out (LIFO) data structure that follows the principle of adding and removing elements from the same end, called the "top" of the stack.

## Features

- **Push:** Adds an element to the top of the stack.
- **Pop:** Removes and returns the element from the top of the stack.
- **Peek:** Returns the element at the top of the stack without removing it.
- **isEmpty:** Checks if the stack is empty.

## Stack Overview

A stack is a fundamental data structure that operates on the Last In First Out (LIFO) principle. This means that the last element added to the stack is the first one to be removed. The main operations on a stack are:

- **Push:** Adds an element to the top of the stack.
- **Pop:** Removes and returns the element from the top of the stack.
- **Peek:** Returns the element at the top of the stack without removing it.

Stacks are widely used in various computer science applications, including expression evaluation, function call management in programming languages, and managing undo functionality in applications.

## Usage

To use the stack in your Kotlin project, follow these steps:

1. Copy the `Stack.kt` file into your project.
2. Create a new instance of the `Stack` class.
3. Use the provided methods (`push`, `pop`, `peek`, etc.) to manipulate the stack.

## Example

```kotlin
fun main() {
    val stack = Stack<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)

    println("Top element: ${stack.peek()}") // Output: 3

    stack.pop()

    println("Stack size: ${stack.size}") // Output: 2
}
```
## Contributing
Contributions are welcome! If you want to contribute to this project, please follow the steps outlined in the Contributing Guidelines.
