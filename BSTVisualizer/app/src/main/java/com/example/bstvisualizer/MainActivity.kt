package com.example.bstvisualizer

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var bstView: BSTView
    private val bst = BST()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bstView = findViewById(R.id.bstView)
        val inputNode: EditText = findViewById(R.id.inputNode)
        val btnInsert: Button = findViewById(R.id.btnInsert)
        val btnDelete: Button = findViewById(R.id.btnDelete)
        val btnSearch: Button = findViewById(R.id.btnSearch)

        // Insert node
        btnInsert.setOnClickListener {
            val value = inputNode.text.toString().toIntOrNull()
            if (value != null) {
                bst.insert(value)
                bstView.setBST(bst)
            }
        }

        // Delete node
        btnDelete.setOnClickListener {
            val value = inputNode.text.toString().toIntOrNull()
            if (value != null) {
                bst.delete(value)
                bstView.setBST(bst)
            }
        }

        // Search node
        btnSearch.setOnClickListener {
            val value = inputNode.text.toString().toIntOrNull()
            if (value != null) {
                val found = bst.search(value)
                if (found != null) {
                    bstView.highlightNode(value)
                } else {
                    Toast.makeText(this, "Node not found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
