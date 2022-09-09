package com.example.a16a_network_calls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyBackgroundTask myTask = new MyBackgroundTask();
        myTask.execute("https://reqres.in/api/users?page=2");


    }

    public void request(){

    }
}