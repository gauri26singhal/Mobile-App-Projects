package com.example.bstvisualizer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BSTView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint().apply {
        color = Color.BLACK  // Circle border color
        strokeWidth = 5f
        textSize = 40f
        style = Paint.Style.STROKE
    }

    private val highlightPaint = Paint().apply {
        color = Color.RED  // Highlight searched node
        strokeWidth = 8f
        style = Paint.Style.STROKE
    }

    private val textPaint = Paint().apply {
        color = Color.WHITE  // Node value color
        textSize = 40f
        textAlign = Paint.Align.CENTER
    }

    private var bst: BST? = null
    private var highlightedNode: BST.Node? = null

    fun setBST(tree: BST) {
        this.bst = tree
        invalidate()
    }

    fun highlightNode(value: Int) {
        highlightedNode = bst?.search(value)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        bst?.getRoot()?.let { drawTree(canvas, it, width / 2f, 100f, width / 4f) }
    }

    private fun drawTree(canvas: Canvas, node: BST.Node?, x: Float, y: Float, offset: Float) {
        node ?: return

        // Draw lines connecting nodes
        if (node.left != null) {
            canvas.drawLine(x, y, x - offset, y + 100, paint)
            drawTree(canvas, node.left, x - offset, y + 100, offset / 2)
        }
        if (node.right != null) {
            canvas.drawLine(x, y, x + offset, y + 100, paint)
            drawTree(canvas, node.right, x + offset, y + 100, offset / 2)
        }

        // Highlight searched node
        if (node == highlightedNode) {
            canvas.drawCircle(x, y, 40f, highlightPaint)
        } else {
            canvas.drawCircle(x, y, 40f, paint)
        }

        // Fill node with black color
        canvas.drawCircle(x, y, 40f, Paint().apply {
            color = Color.BLACK
            style = Paint.Style.FILL
        })

        // Draw node value in white
        canvas.drawText(node.value.toString(), x, y + 15, textPaint)
    }
}
