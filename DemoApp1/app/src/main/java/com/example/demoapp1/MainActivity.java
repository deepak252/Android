package com.example.demoapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextNumber);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public  void onClick(View view){
//                String s = editText.getText().toString();
//                textView.setText(s);
//                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
//            }
//        });

    }
    public void calculate(View view){
        String s = editText.getText().toString();
        textView.setText(s);
        Toast.makeText(getApplicationContext(),"Thanks for using the app",Toast.LENGTH_SHORT).show();
    }
}