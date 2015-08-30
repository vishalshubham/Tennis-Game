package tennisgame.com.tennisgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Vishal on 29/08/2015.
 */
public class GameView extends SurfaceView implements Drawable.Callback{

    private Bitmap button;
    private GameRunner runner;
    private Game game;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        button = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        SurfaceHolder holder = getHolder();
        Canvas canvas = holder.lockCanvas();

        if(canvas!=null){
            canvas.drawColor(Color.WHITE);

            canvas.drawBitmap(button, 50, 50, null);

            holder.unlockCanvasAndPost(canvas);
        }

        return true;
    }

    public void surfaceChanged(){

    }

    public void surfaceCreated(SurfaceHolder holder){
        game = new Game(holder, getResources());
        runner = new GameRunner(game);
        runner.start();
    }

    public void surfaceDestroyed(){
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
