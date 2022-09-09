package com.example.a7e_spinner_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayList<String> spinnerItems = new ArrayList<>();
    private ArrayList<String> actvItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.actv);
        setSpinnerItems();
        setActvItems();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerItems);
        spinner.setAdapter(spinnerAdapter);

        ArrayAdapter<String> actvAdapter  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,actvItems);
        autoCompleteTextView.setAdapter(actvAdapter);
        autoCompleteTextView.setThreshold(5);//No. of characters after which to show dropdown

    }

    public void setSpinnerItems(){
        spinnerItems.add("Item 1");
        spinnerItems.add("Item 2");
        spinnerItems.add("Item 3");
        spinnerItems.add("Item 4");
        spinnerItems.add("Item 5");
        spinnerItems.add("Item 6");
        spinnerItems.add("Item 7");
    }
    public void setActvItems(){
        actvItems.add("Delhi");
        actvItems.add("Noida");
        actvItems.add("Dehradun");
        actvItems.add("Dehradun2");
        actvItems.add("Dehradun3");
        actvItems.add("Dehradun4");
        actvItems.add("Dehradun4");
        actvItems.add("Dehradun4");
        actvItems.add("Mumbai");
        actvItems.add("District");
        actvItems.add("Bhopal");
        actvItems.add("Kanpur");
    }
}