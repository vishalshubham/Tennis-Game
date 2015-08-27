package tennisgame.com.tennisgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Vishal on 29/08/2015.
 */
public class GameView extends SurfaceView implements android.view.SurfaceHolder.Callback{

    private Bitmap button;
    private GameRunner runner;
    private Game game;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        SurfaceHolder holder = getHolder();

        holder.addCallback(this);

        //button = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        game.onToucnEvent(event);

        return true;
    }

    public void surfaceCreated(SurfaceHolder holder){
        game = new Game(holder, getResources(), getWidth(), getHeight());
        runner = new GameRunner(game);
        runner.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    public void surfaceDestroyed(SurfaceHolder holder){
        if(runner != null){
            runner.shutdown();
            while(runner!=null){
                try {
                    runner.join();
                    runner = null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
