package tennisgame.com.tennisgame;

/**
 * Created by Vishal on 30/08/2015.
 */
public class Ball extends Sprite{

    private float speedX = 0.5f;
    private float speedY = 0.5f;

    private int directionX = 1;
    private int directionY = 1;

    public Ball(int width, int height) {
        super(width, height);
    }

    public void update(long elapsed){
        float x = getX();
        float y = getY();

        x += directionX * speedX * elapsed;
        y += directionY * speedY * elapsed;

        setX(x);
        setY(y);
    }
}
