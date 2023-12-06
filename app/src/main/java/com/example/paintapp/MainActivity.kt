package com.example.paintapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageButton
import android.widget.Toast

import com.example.paintapp.PaintView.Companion.colorList
import com.example.paintapp.PaintView.Companion.currentBrush
import com.example.paintapp.PaintView.Companion.pathList


class MainActivity : AppCompatActivity() {

    companion object {
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val orabtn = findViewById<ImageButton>(R.id.orangecolor)
        val majbtn = findViewById<ImageButton>(R.id.majcolor)
        val blubtn = findViewById<ImageButton>(R.id.bluecolor)
        val whibtn = findViewById<ImageButton>(R.id.blackcolor)

        orabtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.color= Color.RED
            currentColor(paintBrush.color)

        }
        majbtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.YELLOW
            currentColor(paintBrush.color)


        }
        blubtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.GREEN
            currentColor(paintBrush.color)

        }
        whibtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()

        }

    }

    private fun currentColor(color: Int) {

        currentBrush = color
        path = Path()
    }
}