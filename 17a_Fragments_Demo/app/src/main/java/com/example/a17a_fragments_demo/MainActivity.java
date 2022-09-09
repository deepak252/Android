package com.example.a17a_fragments_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnFragA;
    Button btnFragB;
    static int currFrag = -1; //0->A , 1-> B

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        loadFragment(new AFragment(),0);
        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AFragment(),0);
            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new BFragment(),1);
            }
        });
    }

    public void loadFragment(Fragment fragment, int flag){
        if(currFrag==flag){
            Toast.makeText(this, "Already in current fragment", Toast.LENGTH_SHORT).show();
            return;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft  = fm.beginTransaction();
        if(currFrag==-1)
            ft.add(R.id.container, fragment);
        else
            ft.replace(R.id.container, fragment);
        currFrag = flag;
        ft.commit();
    }
}