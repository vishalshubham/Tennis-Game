package tennisgame.com.tennisgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

/**
 * Created by Vishal on 29/08/2015.
 */
public class Game {
    private SurfaceHolder holder;
    private Resources resources;
    private Sprite ball;

    public Game(SurfaceHolder holder, Resources resources, int width, int height){
        this.holder = holder;
        this.resources = resources;
        ball = new Sprite(width, height);
    }

    public void init(){
        Bitmap ballimage = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher);

        ball.init(ballimage);
    }

    public void update(long elapsed){

    }

    public void draw(){
        Canvas canvas = holder.lockCanvas();

        if(canvas!=null){

            ball.draw(canvas);

            canvas.drawColor(Color.WHITE);

            //canvas.drawBitmap(button, 50, 50, null);

            holder.unlockCanvasAndPost(canvas);
        }
    }
}