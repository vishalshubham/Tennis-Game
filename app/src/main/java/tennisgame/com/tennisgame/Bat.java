package tennisgame.com.tennisgame;

import android.graphics.Bitmap;

import java.text.FieldPosition;

/**
 * Created by Vishal on 30/08/2015.
 */
public class Bat extends Sprite {

    public void setPosition(float y) {
        setY(y-getRect().centerY());
    }

    public enum Position{
        LEFT, RIGHT
    }

    private static final int margin = 20;
    private Position position;

    public Bat(int width, int height, Position position) {
        super(width, height);
        this.position = position;
    }

    @Override
    public void init(Bitmap image) {
        super.init(image);

        setY(getHeight() / 2 - getRect().centerY());
        if(position == Position.LEFT){
            setX(margin);
        } else if(position == Position.RIGHT){
            setX((getWidth() - margin)-getRect().centerX());
        }
    }
}
