package tennisgame.com.tennisgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Vishal on 29/08/2015.
 */
public class Sprite {

    public float x;
    public float y;
    public int width;
    public int height;
    private Bitmap image;

    public Sprite(int width, int height){
        this.x = 30;
        this.y = 30;
        this.width = width;
        this.height = height;
    }

    public void init(Bitmap image){
        this.image = image;
    }

    public void update(long elapsed){

    }

    public void draw(Canvas canvas){

        canvas.drawBitmap(image, x, y, null);
    }

}
