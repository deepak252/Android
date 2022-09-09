package com.example.a7d_recycler_view_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    Contact[] contacts = {
            new Contact(1,"Deepak", "9876543210"),
            new Contact(2,"Deepak1", "9876543211"),
            new Contact(3,"Deepak2", "9876543212"),
            new Contact(4,"Deepak3", "9876543213"),
            new Contact(5,"Deepak4", "9876543214"),
            new Contact(6,"Deepak5", "9876543215"),
            new Contact(7,"Deepak6", "9876543216"),
            new Contact(8,"Deepak7", "9876543217"),
            new Contact(9,"Deepak8", "9876543218"),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view_contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter customAdapter = new CustomAdapter(contacts);
        recyclerView.setAdapter(customAdapter);
    }
}