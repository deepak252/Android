package com.example.a7b_custom_adapter_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    User[] users = {
            new User("Deepak","deepak@gmail.com","9876543210"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
            new User("Shivam","shivam@gmail.com","9876543211"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview_users);
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(MainActivity.this,R.layout.list_tile_layout,users);
        listView.setAdapter(myCustomAdapter);

    }
}