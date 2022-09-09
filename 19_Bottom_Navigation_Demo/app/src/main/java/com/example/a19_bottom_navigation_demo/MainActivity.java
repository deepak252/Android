package com.example.a19_bottom_navigation_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentManager fm;
    static int navIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        fm = getSupportFragmentManager();

        bottomNavigationView.setSelectedItemId(R.id.navHome);
        loadFragment(new AFragment(),0);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.navHome){
                    loadFragment(new AFragment(),0);
                }else if(itemId == R.id.navReels){
                    loadFragment(new BFragment(),1);
                }else if(itemId == R.id.navProfile){
                    loadFragment(new CFragment(),2);
                }
                return true;
            }
        });

    }

    public void loadFragment(Fragment fragment, int index){
        if(index == navIndex)
            return;
        navIndex = index;
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.dashboardContainer,fragment);
        ft.commit();
    }


}