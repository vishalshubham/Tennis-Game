package tennisgame.com.tennisgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by Vishal on 29/08/2015.
 */
public class Game {
    private SurfaceHolder holder;
    private Resources resources;

    private Ball ball;
    private Bat player;
    private Bat opponent;

    public Game(SurfaceHolder holder, Resources resources, int width, int height){
        this.holder = holder;
        this.resources = resources;

        ball = new Ball(width, height);
        player = new Bat(width, height);
        opponent = new Bat(width, height);
    }

    public void init(){
        Bitmap ballimage = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher);
        ball.init(ballimage);
        player.init(ballimage);
        opponent.init(ballimage);
    }

    public void update(long elapsed){
        ball.update(elapsed);
    }

    public void draw(){
        Log.d("VC", "----------------------Should draw2");
        Canvas canvas = holder.lockCanvas();

        if(canvas!=null){

            canvas.drawColor(Color.WHITE);

            ball.draw(canvas);
            player.draw(canvas);
            opponent.draw(canvas);

            holder.unlockCanvasAndPost(canvas);
        }
    }
}
