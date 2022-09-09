package com.example.a4_multiple_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    //This field should be unique key.
    public static final String EXTRA_NAME = "com.example.a4_multiple_screens.extra.NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextTextPersonName2);

    }
    //Open Activity
    public void navigateToScreen(View view){
        Log.d("Hello","world");
        String name = editText.getText().toString();
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra(EXTRA_NAME,name);
        startActivity(intent);
    }
}