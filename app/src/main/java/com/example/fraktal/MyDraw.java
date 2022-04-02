package com.example.fraktal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;



public class MyDraw extends View {
    Paint paint = new Paint();
    int w, h;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
    }

    public MyDraw (Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas){
        drawRect(canvas, w/2, h/2, 200);
        }

    public void drawRect(Canvas canvas, int x, int y, int r) {
        canvas.drawRect(x - r, y - r, x + r, y + r, paint);
        if (r > 50) {
            drawRect(canvas, x - r, y - r, r / 2);
            drawRect(canvas, x + r, y - r, r / 2);
            drawRect(canvas, x + r, y + r, r / 2);
            drawRect(canvas, x - r, y + r, r / 2);
        }
    }
}