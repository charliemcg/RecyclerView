package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //These are the items which will be displayed in the recycler view
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");
        items.add("Item 6");

        //get the recycler view
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        //get an adapter
        RecyclerAdapter adapter = new RecyclerAdapter(items, this);
        //set the adapter to the recycler view
        recyclerView.setAdapter(adapter);
        //from developer.android.com
        //In contrast to other adapter-backed views such as ListView or GridView,
        // RecyclerView allows client code to provide custom layout arrangements for
        // child views. These arrangements are controlled by the RecyclerView.LayoutManager.
        // A LayoutManager must be provided for RecyclerView to function.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
