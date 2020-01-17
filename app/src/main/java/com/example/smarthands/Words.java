package com.example.smarthands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Words extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        System.out.println("Hello"+fields.length);
        for (int count = 0; count < fields.length; count++) {
            Log.d("Raw Asset: ", fields[count].getName());
            listItems.add(new Listitem(fields[count].getName()));
        }



        adapter = new imageAdapter(listItems, this);
        recyclerView.setAdapter(adapter);

    }
}

//