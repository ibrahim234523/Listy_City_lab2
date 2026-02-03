package com.example.listycity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Button addButton, confirmButton, deleteButton;
    EditText cityInput;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityList =  findViewById(R.id.city_list);
        String[] cities = {"Islamabad", "Washington", "London", "Tokyo"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this,R.layout.content,dataList);
        cityList.setAdapter(cityAdapter);

        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);
        cityInput = findViewById(R.id.cityInput);

        cityList.setOnItemClickListener((parent, view, position, id) -> selectedIndex = position);
        addButton.setOnClickListener(v -> {
            String city = cityInput.getText().toString().trim();
            if (!city.isEmpty())
            {
                dataList.add(city);
                cityAdapter.notifyDataSetChanged();
                cityInput.setText("");
            }
        });
        deleteButton.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                dataList.remove(selectedIndex);
                cityAdapter.notifyDataSetChanged();
                selectedIndex = -1;
            }
        });
    }


}