package tennisgame.com.tennisgame;

import android.util.Log;

/**
 * Created by Vishal on 29/08/2015.
 */
public class GameRunner extends Thread {

    private Game game;
    private volatile boolean running = true;

    public GameRunner(Game game){
        this.game = game;
    }

    @Override
    public void run() {

        game.init();

        long lastTime=System.currentTimeMillis();
        while(running){

            /*Log.d("","Thread Running");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            long now = System.currentTimeMillis();
            long elapsed = now - lastTime;

            if(elapsed<100){
                game.update(elapsed);
                game.draw();
            }
            lastTime = now;
        }
    }

    public void shutdown(){
        running = false;
    }
}
