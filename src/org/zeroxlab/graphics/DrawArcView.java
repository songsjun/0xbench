/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.zeroxlab.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;


class DrawArcView extends SurfaceView {

    private SurfaceHolder mSurfaceHolder;
    private int angle = 0;
    private int step = 5;
    private boolean center = false;

    protected void doDraw() {
        Canvas canvas = mSurfaceHolder.lockCanvas();
        drawArc(canvas);
        mSurfaceHolder.unlockCanvasAndPost(canvas);
    }

    private void drawArc(Canvas canvas) {
        int color = (0x00252525 | new Random().nextInt() ) | Color.BLACK; 
        Paint p = new Paint();
        p.setAntiAlias(false);
        p.setStyle(Paint.Style.FILL);
        p.setColor(color);

        canvas.drawArc(new RectF(0,0, getWidth(), getHeight()), 0, angle, center, p);
        center = !center;
        angle += step;
        if (angle >= 360) {
            angle = 0;
        }
    }

    public DrawArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSurfaceHolder = getHolder();
    }
}

