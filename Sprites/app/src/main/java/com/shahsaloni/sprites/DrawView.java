package com.shahsaloni.sprites;

import static android.graphics.RectF.intersects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {

    Sprite sprite = new Sprite();
    Sprite sprite2 = new Sprite(300, 100, 400, 210,-2, 3, Color.BLUE);

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        sprite = new Sprite();
        sprite2 = new Sprite(300, 100, 400, 210,-12, 13, Color.BLUE);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sprite.update(canvas);
        sprite2.update(canvas);
        sprite.draw(canvas);
        sprite2.draw(canvas);

        Paint p = new Paint();
        p.setColor(Color.BLACK);
        canvas.drawRect(0, 0, 50, getHeight(), p);
        canvas.drawRect(0, 0, getWidth(), 50, p);
        canvas.drawRect(getWidth() - 50, 0, getWidth(), getHeight(), p);
        canvas.drawRect(0, getHeight() - 50, getWidth(), getHeight(), p);

        twoSpriteIntersection(sprite, sprite2);

        invalidate();
    }

    public void twoSpriteIntersection(Sprite s1, Sprite s2) {

        if(intersects(s1, s2)) {
            s2.setdY(-(s2.getdY()));
            s1.setdY(-(s1.getdY()));
        }

        if(s1.intersects(0, 0, 50, getHeight())) {
            s1.setdX(-(s1.getdX()));
            s1.setColor(Color.YELLOW);
        }
        if(s1.intersects(0, 0, getWidth(), 50)) {
            s1.setdY(-(s1.getdY()));
            s1.setColor(Color.CYAN);
        }
        if(s1.intersects(getWidth() - 50, 0, getWidth(), getHeight())) {
            s1.setdX(-(s1.getdX()));
            s1.setColor(Color.BLACK);
        }
        if(s1.intersects(0, getHeight() - 50, getWidth(), getHeight())) {
            s1.setdY(-(s1.getdY()));
            s1.setColor(Color.BLUE);
        }

        if(s2.intersects(0, 0, 50, getHeight())) {
            s2.setdX(-(s2.getdX()));
            s2.setColor(Color.RED);
        }
        if(s2.intersects(0, 0, getWidth(), 50)) {
            s2.setdY(-(s2.getdY()));
            s2.setColor(Color.GREEN);
        }
        if(s2.intersects(getWidth() - 50, 0, getWidth(), getHeight())) {
            s2.setdX(-(s2.getdX()));
            s2.setColor(Color.LTGRAY);
        }
        if(s2.intersects(0, getHeight() - 50, getWidth(), getHeight())) {
            s2.setdY(-(s2.getdY()));
            s2.setColor(Color.MAGENTA);
        }

    }


}
