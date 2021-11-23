package com.shahsaloni.lab09game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;

public class Sprite extends RectF {

    private int dX, dY, color, fps, numFrames, currentFrame, spriteHeight, spriteWidth;
    private Bitmap bitmap;
    private Rect rect;
    private boolean loop, dispose;
    private long frameTimer;


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

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public int getNumFrames() {
        return numFrames;
    }

    public void setNumFrames(int numFrames) {
        this.numFrames = numFrames;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }

    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Rect getRectF() {
        return rect;
    }

    public void setRectF(Rect rect) {
        this.rect = rect;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isDispose() {
        return dispose;
    }

    public void setDispose(boolean dispose) {
        this.dispose = dispose;
    }

    public long getFrameTimer() {
        return frameTimer;
    }

    public void setFrameTimer(long frameTimer) {
        this.frameTimer = frameTimer;
    }


    public void initialize(Bitmap bm, int height, int width, int fps, int frameCount, boolean loop) {
        this.bitmap = bm;
        this.spriteHeight = height;
        this.spriteWidth = width;
        this.rect.top = 0;
        this.rect.bottom = spriteHeight;
        this.rect.left = 0;
        this.rect.right = spriteWidth;
        this.fps = 1000 / fps;
        this.numFrames = frameCount;
        this.loop = loop;
    }

    public void update(long gameTime) {
        if( gameTime > frameTimer + fps) {
            frameTimer = gameTime;
            currentFrame += 1;

            if( currentFrame >= numFrames ) {
                currentFrame = 0;

                if(!loop) dispose = true;
            }

            rect.left = currentFrame * spriteWidth;
            rect.right = rect.left + spriteWidth;
        }
    }

    public void draw(Canvas canvas) {
        RectF dest = new RectF(getdX(), getdY(), getdX() + spriteWidth,
                getdY() + spriteHeight);
        canvas.drawBitmap(bitmap, rect, dest, null);
    }

}
