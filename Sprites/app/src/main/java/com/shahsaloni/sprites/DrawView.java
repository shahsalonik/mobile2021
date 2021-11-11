package com.shahsaloni.sprites;

import static android.graphics.RectF.intersects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
        sprite2 = new Sprite(300, 100, 400, 210,-2, 3, Color.BLUE);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sprite.update();
        sprite2.update();
        sprite.draw(canvas);
        sprite2.draw(canvas);

        Paint p = new Paint();
        p.setColor(Color.BLACK);
        canvas.drawRect(0, 0, 50, getHeight(), p);
        canvas.drawRect(0, 0, getWidth(), 50, p);
        canvas.drawRect(getWidth() - 50, 0, getWidth(), getHeight(), p);
        canvas.drawRect(0, getHeight() - 50, getWidth(), getHeight(), p);

        if(intersects(sprite, sprite2)) {
            sprite2.setdY(-(sprite2.getdY()));
            sprite.setdY(-(sprite.getdY()));
        }

        if(sprite.intersects(0, 0, 50, getHeight())) {
            sprite.setdX(-(sprite.getdX()));
        }
        if(sprite.intersects(0, 0, getWidth(), 50)) {
            sprite.setdY(-(sprite.getdY()));
        }
        if(sprite.intersects(getWidth() - 50, 0, getWidth(), getHeight())) {
            sprite.setdX(-(sprite.getdX()));
        }
        if(sprite.intersects(0, getHeight() - 50, getWidth(), getHeight())) {
            sprite.setdY(-(sprite.getdY()));
        }

        if(sprite2.intersects(0, 0, 50, getHeight())) {
            sprite2.setdX(-(sprite2.getdX()));
        }
        if(sprite2.intersects(0, 0, getWidth(), 50)) {
            sprite2.setdY(-(sprite2.getdY()));
        }
        if(sprite2.intersects(getWidth() - 50, 0, getWidth(), getHeight())) {
            sprite2.setdX(-(sprite2.getdX()));
        }
        if(sprite2.intersects(0, getHeight() - 50, getWidth(), getHeight())) {
            sprite2.setdY(-(sprite2.getdY()));
        }

        invalidate();
    }


}
