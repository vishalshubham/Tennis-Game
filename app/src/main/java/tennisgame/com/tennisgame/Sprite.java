package tennisgame.com.tennisgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Vishal on 29/08/2015.
 */
public class Sprite {

    public float x;
    public float y;
    public int width;
    public int height;
    private Bitmap image;

    private Rect bounds;

    public Sprite(int width, int height){
        this.x = 30;
        this.y = 30;
        this.width = width;
        this.height = height;
    }

    public void init(Bitmap image){
        this.image = image;
        bounds = new Rect(0, 0, image.getWidth(), image.getHeight());
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image, x, y, null);
    }

    public Rect getRect(){
        return bounds;
    }

    public Rect getScreenRect(){
        return new Rect((int)x, (int)y, (int)x + getRect().width(), (int)y + getRect().height());
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
