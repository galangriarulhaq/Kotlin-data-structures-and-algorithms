package data_structures.trees.tree_traversal

class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTree {
    var root: TreeNode? = null

    // Inorder Traversal (Left, Root, Right)
    fun inorderTraversal(node: TreeNode?) {
        if (node != null) {
            inorderTraversal(node.left)
            print("${node.value} ")
            inorderTraversal(node.right)
        }
    }

    // Preorder Traversal (Root, Left, Right)
    fun preorderTraversal(node: TreeNode?) {
        if (node != null) {
            print("${node.value} ")
            preorderTraversal(node.left)
            preorderTraversal(node.right)
        }
    }

    // Postorder Traversal (Left, Right, Root)
    fun postorderTraversal(node: TreeNode?) {
        if (node != null) {
            postorderTraversal(node.left)
            postorderTraversal(node.right)
            print("${node.value} ")
        }
    }
}

fun main() {
    // Creating a simple binary tree
    val tree = BinaryTree()
    tree.root = TreeNode(1)
    tree.root?.left = TreeNode(2)
    tree.root?.right = TreeNode(3)
    tree.root?.left?.left = TreeNode(4)
    tree.root?.left?.right = TreeNode(5)

    // Inorder Traversal
    println("Inorder Traversal:")
    tree.inorderTraversal(tree.root)
    println()

    // Preorder Traversal
    println("Preorder Traversal:")
    tree.preorderTraversal(tree.root)
    println()

    // Postorder Traversal
    println("Postorder Traversal:")
    tree.postorderTraversal(tree.root)
    println()
}
