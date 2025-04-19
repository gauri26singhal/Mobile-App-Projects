package com.example.bstvisualizer

class BST {
    data class Node(var value: Int, var left: Node? = null, var right: Node? = null)

    private var root: Node? = null

    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(root: Node?, value: Int): Node {
        if (root == null) return Node(value)
        if (value < root.value) {
            root.left = insertRec(root.left, value)
        } else if (value > root.value) {
            root.right = insertRec(root.right, value)
        }
        return root
    }

    fun delete(value: Int) {
        root = deleteRec(root, value)
    }

    private fun deleteRec(root: Node?, value: Int): Node? {
        if (root == null) return null
        when {
            value < root.value -> root.left = deleteRec(root.left, value)
            value > root.value -> root.right = deleteRec(root.right, value)
            else -> {
                if (root.left == null) return root.right
                if (root.right == null) return root.left
                root.value = findMin(root.right!!)
                root.right = deleteRec(root.right, root.value)
            }
        }
        return root
    }

    private fun findMin(node: Node): Int {
        return node.left?.let { findMin(it) } ?: node.value
    }

    fun getRoot(): Node? = root

    // 🔹 Search function
    fun search(value: Int): Node? {
        return searchRec(root, value)
    }

    private fun searchRec(node: Node?, value: Int): Node? {
        return when {
            node == null -> null
            value == node.value -> node
            value < node.value -> searchRec(node.left, value)
            else -> searchRec(node.right, value)
        }
    }
}
