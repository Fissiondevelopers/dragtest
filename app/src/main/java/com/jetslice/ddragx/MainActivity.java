package com.jetslice.ddragx;

import android.app.Activity;

import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView tvx;
    String msg;
    ImageView imgx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvx =findViewById(R.id.iew);
        imgx=findViewById(R.id.imgv);
        tvx.setOnTouchListener(new View.OnTouchListener() {
            float lastX = imgx.getHeight(), lastY = imgx.getWidth();
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case (MotionEvent.ACTION_DOWN):
                        lastX = event.getX();
                        lastY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float dx = event.getX() - lastX;
                        float dy = event.getY() - lastY;
                        float finalX = v.getX() + dx;
                        float finalY = v.getY() + dy + v.getHeight();               v.setX(finalX);
                        v.setY(finalY);
                        break;
                }
                return true;
            }
        });
    }
}
