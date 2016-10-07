package io.github.charly1811.android.watchface.minimalist;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.wearable.watchface.CanvasWatchFaceService;
import android.text.TextPaint;
import android.view.SurfaceHolder;

/**
 * On Android Wear Watch Face is implemented as a service.
 * Every Watch Face Service extends from the WatchFaceService class and
 * Must provide a WatchFace Engine
 */

public class MinimalistWatchFaceService extends CanvasWatchFaceService {

    @Override
    public Engine onCreateEngine() {
        return new MinimalWatchFaceEngine();
    }

    /**
     * The engine is responsible for the Drawing of the watch face and
     * receives events from the system
     */
    public class MinimalWatchFaceEngine extends Engine {

        private TextPaint timePaint;

        // Called when the watch face service is created for the first time
        // We will initialize our drawing components here
        @Override
        public void onCreate(SurfaceHolder holder) {
            super.onCreate(holder);
            timePaint = new TextPaint();
            timePaint.setColor(Color.WHITE);
        }

        @Override
        public void onDraw(Canvas canvas, Rect bounds) {
            super.onDraw(canvas, bounds);
            // We draw the watch face here

            String text = String.valueOf(System.currentTimeMillis());

            Rect textBounds = new Rect();
            timePaint.getTextBounds(text, 0, text.length(), textBounds);

            int textX = Math.abs(bounds.centerX() - textBounds.centerX());
            int textY = Math.abs(bounds.centerY() - textBounds.centerY());

            canvas.drawText(text, textX, textY, timePaint);
        }
    }
}
