package com.shahsaloni.sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class Sprite extends RectF {

    private int dX, dY, color, currentFrame = 0, iconWidth, iconHeight;
    private Bitmap bitmap;
    private static final int BMP_COLUMNS = 4;
    private static final int BMP_ROWS = 4;
    private static final int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;

    public Sprite(float left, float top, float right, float bottom, int dX, int dY, int color) {
        super(left, top, right, bottom);
        this.dX = dX;
        this.dY = dY;
        this.color = color;
    }

    public Sprite(float left, float top, float right, float bottom) {
        this(left, top, right, bottom, 11, 12, Color.MAGENTA);
    }

    public Sprite(int dX, int dY, int color) {
        this(70, 600, 170, 710, dX, dY, color);
    }

    public Sprite() {
        this(12, 13, Color.GREEN);
    }

    public Sprite(Bitmap bm) {
        this(12, 13, Color.GREEN);
        bitmap = bm;
    }

    public void update(Canvas canvas) {
        if(left + dX < 0 || right + dX > canvas.getWidth()) {
            dX =- 1;
        }
        if(top + dY > canvas.getHeight()) {
            offsetTo(left, -height());
        }
        if(bottom + dY < 0) {
            offset(left, canvas.getHeight());
        }
        offset(dX, dY);
    }

    public void draw(Canvas canvas) {
        if(bitmap == null) {
            Paint paint = new Paint();
            paint.setColor(color);
            canvas.drawCircle(centerX(), centerY(), width() / 2, paint);
        }
        else {
            iconWidth = bitmap.getWidth();
            iconHeight = bitmap.getHeight();
            int srcX = currentFrame * iconWidth;
            int srcY = getAnimationRow() * iconHeight;
            Rect src = new Rect(srcX, srcY, srcX + iconWidth, srcY + iconHeight);
            canvas.drawBitmap(bitmap, src, this, null);
        }
    }

    private int getAnimationRow() {
        if(Math.abs(dX) > Math.abs(dY)) {
            if(Math.abs(dX) == dX) {
                return RIGHT;
            }
            else {
                return LEFT;
            }
        }
        else if(Math.abs(dY) == dY) {
            return DOWN;
        }
        else {
            return UP;
        }
    }


    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap b) {
        bitmap = b;
    }

    public void grow(int i) {
        right += i;
        bottom += i;
    }

}
