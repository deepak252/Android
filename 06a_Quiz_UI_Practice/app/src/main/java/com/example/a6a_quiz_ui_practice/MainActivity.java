package com.example.a6a_quiz_ui_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnYes;
    private Button btnNo;
    private TextView txtViewQuestion;
    private TextView textViewScore;
    public static int currentIndex=0;
    public static int score = 0;
    Question questions[]={
            new Question("Sharks are mammals.",false),
            new Question("The blue whale is the biggest animal to have ever lived.",true),
            new Question("A dog sweats by panting its tongue.",false),
            new Question("It takes a sloth two weeks to digest a meal.",true),
            new Question("The blue whale is the biggest animal to have ever lived.",true),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnYes = findViewById(R.id.buttonYes);
        btnNo = findViewById(R.id.buttonNo);
        txtViewQuestion = findViewById(R.id.textQuestion);
        textViewScore = findViewById(R.id.textScore);

        txtViewQuestion.setText(questions[currentIndex].question);
        textViewScore.setText(getString(R.string.score,score,questions.length));

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isQuizEnded()) return;
                if(questions[currentIndex].ans){
                    score++;
                }
                nextQuestion();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isQuizEnded()) return;
                if(currentIndex>=questions.length){
                    Toast.makeText(MainActivity.this,"Your Score is "+String.valueOf(score),Toast.LENGTH_SHORT).show();
                }
                if(!questions[currentIndex].ans){
                    score++;
                }
                nextQuestion();
            }
        });
    }

    public boolean isQuizEnded(){
        if(currentIndex>=questions.length){
            Toast.makeText(MainActivity.this,"Your Score is "+String.valueOf(score),Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public void nextQuestion(){
        Log.d("Question Number", String.valueOf(currentIndex));
        textViewScore.setText(getString(R.string.score,score,questions.length));
        currentIndex++;
        if(currentIndex<5){
            txtViewQuestion.setText(questions[currentIndex].question);
        }
    }

}