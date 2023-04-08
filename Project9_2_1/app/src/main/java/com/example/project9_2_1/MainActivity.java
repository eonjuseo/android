package com.example.project9_2_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project9_2_1.R;

@SuppressWarnings("deprecation")

public class MainActivity extends AppCompatActivity {

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static boolean blur = false;
    static boolean embos = false;
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright,
            ibDar, ibEmbos, ibBlur;
    MyGraphicView graphicView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("미니 포토샵(개선)");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons() {
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });

        ibZoomout = (ImageButton) findViewById((R.id.ibZoomin));
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibFlush);
        ibDar = (ImageButton) findViewById(R.id.ibBlur);
        ibEmbos = (ImageButton) findViewById(R.id.ibEmbos);

        ibBright.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color + 0.2f;
                graphicView.invalidate();
            }
        });

        ibDar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });

        ibBlur.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (blur == false) blur = true;
                else blur = false;
                graphicView.invalidate();
            }
        });

        ibEmbos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (embos == false) embos = true;
                else embos = false;
                graphicView.invalidate();
            }
        });
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array = {color, 0, 0, 0, 0,
                    0, color, 0, 0, 0,
                    0, 0, color, 0, 0,
                    0, 0, 0, 1, 0};
            ColorMatrix cm = new ColorMatrix(array);
            if (blur == true) {
                BlurMaskFilter bMask;
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(bMask);
            }
            if (embos == true) {
                EmbossMaskFilter eMask;
                eMask = new EmbossMaskFilter(new float[]{3, 3, 3}, 0.5f,
                        5, 10);
                paint.setMaskFilter(eMask);
            }
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getWidth() - picture.getWidth()) / 2;

            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }
}