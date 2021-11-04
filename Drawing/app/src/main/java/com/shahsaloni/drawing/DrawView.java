package com.shahsaloni.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    private Paint p = new Paint();
    private int y = 1000, dY = 5;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.argb(255, 92, 64, 51));
        canvas.drawRect(450, 1100, 600, 2000, p);

        p.setColor(Color.argb(255, 255, 192, 203));
        canvas.drawCircle(375, 1000, 200, p);
        canvas.drawCircle(525, 700, 200, p);
        canvas.drawCircle(675, 1000, 200, p);
        canvas.drawCircle(300, 800, 150, p);
        canvas.drawCircle(700, 800, 150, p);
        canvas.drawCircle(700, y, 70, p);

        p.setColor(Color.argb(255, 0,128,0));
        canvas.drawRect(0, 1800, 2000, 2000, p);

        p.setColor(Color.argb(255, 255, 182, 25));
        canvas.drawCircle(105, 120, 90, p);

        y += dY;
        y %= getHeight();
        invalidate();

    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

}
