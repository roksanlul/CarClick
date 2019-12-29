package com.example.carclick;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public float screenW;
    public float screenH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowManager wm = getWindowManager();
        Display dips = wm.getDefaultDisplay();
        Point size = new Point();
        dips.getSize(size);
        screenW = size.x;
        screenH = size.y;

        ImageView car1 = (ImageView)findViewById(R.id.car1);
        n = (float) (car1.getLayoutParams().height * 1.6);

        ImageView car2 = (ImageView)findViewById(R.id.car2);
        n1 = (float) (car1.getLayoutParams().height * 1.6);
    }

    private float n;
    private float n1;

    public void fCar(View view) {

        n += 10;
        ImageView car2 = (ImageView)findViewById(R.id.car2);
        ImageView car1 = (ImageView)findViewById(R.id.car1);
        TextView win = (TextView)findViewById(R.id.winner);
        Button res = (Button)findViewById(R.id.res);
        Button fcb = (Button)findViewById(R.id.fCB);
        Button scb = (Button)findViewById(R.id.sCB);
        car1.setY((float) (screenH - n));
        car1.setX((float) (screenW * 0.2));

        if (car1.getY() < (screenH - (screenH * 0.9))){

            res.setVisibility(View.VISIBLE);
            win.setVisibility(View.VISIBLE);
            car1.setVisibility(View.GONE);
            car2.setVisibility(View.GONE);
            fcb.setVisibility(View.GONE);
            scb.setVisibility(View.GONE);
        }
    }

    public void sCar(View view) {

        n1 += 10;
        ImageView car1 = (ImageView)findViewById(R.id.car1);
        ImageView car2 = (ImageView)findViewById(R.id.car2);
        TextView win = (TextView)findViewById(R.id.winner1);
        Button fcb = (Button)findViewById(R.id.fCB);
        Button scb = (Button)findViewById(R.id.sCB);
        Button res = (Button)findViewById(R.id.res);
        car2.setY((float) (screenH - n1));
        car2.setX((float) (screenW * 0.7));

        if (car2.getY() < (screenH - (screenH * 0.9))){

            res.setVisibility(View.VISIBLE);
            win.setVisibility(View.VISIBLE);
            car1.setVisibility(View.GONE);
            car2.setVisibility(View.GONE);
            fcb.setVisibility(View.GONE);
            scb.setVisibility(View.GONE);
        }
    }

    public void restars(View view) {

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
