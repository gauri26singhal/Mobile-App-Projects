package com.example.graphicalprimitive2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating a Bitmap
        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);

        // Setting the Bitmap as background for the ImageView
        ImageView i = findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bg));

        // Creating the Canvas Object
        Canvas canvas = new Canvas(bg);

        // Creating the Paint Object and setting its color & text size
        Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(50);

        // Move everything 100 pixels upwards
        int offsetY = -30;

        // Draw the Shapes first

        // Rectangle
        canvas.drawRect(400, 100 + offsetY, 650, 600 + offsetY, paint);
        // Circle
        canvas.drawCircle(200, 250 + offsetY, 150, paint);
        // Square
        canvas.drawRect(50, 750 + offsetY, 350, 1050 + offsetY, paint);
        // Line
        canvas.drawLine(520, 750 + offsetY, 520, 1050 + offsetY, paint);

        // Now draw the text below each shape

        // Rectangle Label
        canvas.drawText("Rectangle", 420, 650 + offsetY, paint);
        // Circle Label
        canvas.drawText("Circle", 120, 500 + offsetY, paint);
        // Square Label
        canvas.drawText("Square", 120, 1100 + offsetY, paint);
        // Line Label
        canvas.drawText("Line", 480, 1100 + offsetY, paint);

        // Author Name at the bottom
        canvas.drawText("Made by - Gauri Singhal", 120, 1150 + offsetY, paint);
    }
}
