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
    private int y = 0, dY = 5;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.argb(255, 150, 75, 0));
        canvas.drawRect(450, 900, 600, 2000, p);

        p.setColor(Color.argb(255, 255, 192, 203));

        for(int x = 0; x < 100; x++) {
            int xPos = (int) (Math.random() * 700 + 200);
            int yPos = (int) (Math.random() * 600 + 400);
            canvas.drawCircle(xPos, yPos, 70, p);
        }

        p.setColor(Color.argb(255, 231, 83, 128));

        for(int x = 0; x < 80; x++) {
            int xPos = (int) (Math.random() * 700 + 200);
            int yPos = (int) (Math.random() * 600 + 400);
            canvas.drawCircle(xPos, yPos, 70, p);
        }

        p.setColor(Color.argb(200, 255, 192, 203));

        for(int x = 0; x < 100; x++) {
            int xPos = (int) (Math.random() * 700 + 200);
            int yPos = (int) (Math.random() * 600 + 400);
            canvas.drawCircle(xPos, yPos, 70, p);
        }

        p.setColor(Color.argb(255, 0,128,0));
        canvas.drawRect(0, 1800, 2000, 2000, p);

        p.setColor(Color.argb(255, 255, 182, 25));
        canvas.drawCircle(105, 120, 90, p);
        
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

}
