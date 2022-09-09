package com.example.a18_appbar_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbarCustom);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setTitle("My Toolbar");
        }
        getSupportActionBar().setTitle("My Custom Toolbar");
        getSupportActionBar().setSubtitle("MY SUBTITLE");


    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu_toolbar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.optNewFolder){
            Toast.makeText(this, "New Folder", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.optCopy){
            Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show();
        }else if(itemId == R.id.optDelete){
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Go Back", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}