package tennisgame.com.tennisgame;

import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Vishal on 30/08/2015.
 */
public class Ball extends Sprite{

    private float speedX = 0.5f;
    private float speedY = 0.5f;

    private int directionX;
    private int directionY;

    public Ball(int width, int height) {
        super(width, height);
    }

    public void update(long elapsed){
        float x = getX();
        float y = getY();

        Rect screenRect = getScreenRect();

        if(screenRect.left <= 0){
            directionX = 1;
        }
        else if(screenRect.right >= getWidth()){
            directionX = -1;
        }

        if(screenRect.top <=0){
            directionY = 1;
        }
        else if(screenRect.bottom >= getHeight()){
            directionY = -1;
        }

        x += directionX * speedX * elapsed;
        y += directionY * speedY * elapsed;

        setX(x);
        setY(y);
    }

    @Override
    public void init(Bitmap image) {
        super.init(image);
        setX(getWidth() / 2 - getRect().centerX());
        setY(getHeight() / 2 - getRect().centerY());
        Random random = new Random();
        directionX = random.nextInt(2)*2 - 1;
        directionY = random.nextInt(2)*2 - 1;
    }
}
