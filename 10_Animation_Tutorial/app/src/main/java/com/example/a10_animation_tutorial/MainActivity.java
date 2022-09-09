package com.example.a10_animation_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonMove;
    private Button buttonAlpha;
    private Button buttonScale;
    private Button buttonRotate;
    private View viewAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewAnim = findViewById(R.id.myView);
        buttonMove = findViewById(R.id.btnMove);
        buttonAlpha = findViewById(R.id.btnAlpha);
        buttonScale = findViewById(R.id.btnScale);
        buttonRotate = findViewById(R.id.btnRotate);


        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation move = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
//                viewAnim.setAnimation(move);
                viewAnim.startAnimation(move);
            }
        });

        buttonAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alpha = AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);
                viewAnim.startAnimation(alpha);
            }
        });

        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                viewAnim.startAnimation(rotate);
            }
        });

        buttonScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation scale = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale);
                viewAnim.startAnimation(scale);
            }
        });
    }
}