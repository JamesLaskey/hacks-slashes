package com.hacksnslashes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by jim on 6/10/14.
 */
public class SurfaceViewDrawer extends SurfaceView implements SurfaceHolder.Callback{

    private class DrawThread extends Thread{
        private Bitmap backgroundBitmap;
        private Handler handler;
        private SurfaceHolder holder;

        public DrawThread(SurfaceHolder holder, Context context, Handler handler){
            this.handler = handler;
            this.holder = holder;

            int[] backgroundColor = {100,100,100};
            backgroundBitmap = Bitmap.createBitmap(backgroundColor, 100, 100, null);

        }

        @Override
        public void run() {
            while (true) {
                Canvas c = null;
                try {
                    c = holder.lockCanvas(null);
                    synchronized (holder) {
                        //if (mMode == STATE_RUNNING) updatePhysics();
                        //doDraw(c);
                    }
                } finally {
                    if (c != null) {
                        holder.unlockCanvasAndPost(c);
                    }
                }
            }
        }

        /**
         * Dump game state to the provided Bundle. Typically called when the
         * Activity is being suspended.
         *
         * @return Bundle with this view's state
         */
        public Bundle saveState(Bundle map) {
            synchronized (holder) {
                if (map != null) {

                }
            }
            return map;
        }

    }

    private DrawThread thread;

    public SurfaceViewDrawer(Context context, AttributeSet attrs){
        super(context, attrs);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        thread = new DrawThread(holder, context, new Handler());

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

    @Override
    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {

    }
}
