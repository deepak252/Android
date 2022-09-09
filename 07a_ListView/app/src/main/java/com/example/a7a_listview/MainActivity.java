package com.example.a7a_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        String messages[] ={"Hello World 1", "Hello World 2","Hello World 3","Hello World 1", "Hello World 2","Hello World 3","Hello World 1", "Hello World 2","Hello World 3","Hello World 1", "Hello World 2","Hello World 3","Hello World 1", "Hello World 2","Hello World 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,messages);
        listView.setAdapter(adapter);
    }
}