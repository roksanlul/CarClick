package com.example.carclick;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.text.Layout;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

@SuppressLint("Registered")
public class gameActivity extends AppCompatActivity {

    public float screenW;
    public float screenH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        WindowManager wm = getWindowManager();
        Display dips = wm.getDefaultDisplay();
        Point size = new Point();
        dips.getSize(size);
        screenW = size.x;
        screenH = size.y;

        ImageView car1 = (ImageView) findViewById(R.id.car1);
        n = (float) (car1.getLayoutParams().height * 1.6);

        ImageView car2 = (ImageView) findViewById(R.id.car2);
        n1 = (float) (car1.getLayoutParams().height * 1.6);
    }

    private float n;
    private float n1;

    public void fCar(View view) {

        n += 49;
        ImageView car2 = (ImageView) findViewById(R.id.car2);
        ImageView car1 = (ImageView) findViewById(R.id.car1);
        TextView win = (TextView) findViewById(R.id.winner);
        Button res = (Button) findViewById(R.id.res);
        Button menu = (Button) findViewById(R.id.menu);
        Button fcb = (Button) findViewById(R.id.fCB);
        Button scb = (Button) findViewById(R.id.sCB);
        car1.setY((float) (screenH - n));
        car1.setX((float) (screenW * 0.2));

        if (car1.getY() < (screenH - (screenH * 0.9))) {

            res.setVisibility(View.VISIBLE);
            win.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);

            car1.setVisibility(View.GONE);
            car2.setVisibility(View.GONE);
            fcb.setVisibility(View.GONE);
            scb.setVisibility(View.GONE);
        }
    }

    public void sCar(View view) {

        n1 += 49;
        ImageView car1 = (ImageView) findViewById(R.id.car1);
        ImageView car2 = (ImageView) findViewById(R.id.car2);
        TextView win = (TextView) findViewById(R.id.winner1);
        Button fcb = (Button) findViewById(R.id.fCB);
        Button menu = (Button) findViewById(R.id.menu);
        Button scb = (Button) findViewById(R.id.sCB);
        Button res = (Button) findViewById(R.id.res);
        car2.setY((float) (screenH - n1));
        car2.setX((float) (screenW * 0.7));

        if (car2.getY() < (screenH - (screenH * 0.9))) {

            res.setVisibility(View.VISIBLE);
            win.setVisibility(View.VISIBLE);
            menu.setVisibility(View.VISIBLE);

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

    public void menu(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            LinearLayout l = (LinearLayout)findViewById(R.id.yesnt);
            ImageView car1 = (ImageView) findViewById(R.id.car1);
            ImageView car2 = (ImageView) findViewById(R.id.car2);

            car1.setVisibility(View.GONE);
            car2.setVisibility(View.GONE);
            l.setVisibility(View.VISIBLE);
        }
        return true;
    }

    public void no(View view) {

        ImageView car1 = (ImageView) findViewById(R.id.car1);
        LinearLayout l = (LinearLayout)findViewById(R.id.yesnt);
        ImageView car2 = (ImageView) findViewById(R.id.car2);

        car1.setVisibility(View.VISIBLE);
        car2.setVisibility(View.VISIBLE);
        l.setVisibility(View.GONE);
    }
}