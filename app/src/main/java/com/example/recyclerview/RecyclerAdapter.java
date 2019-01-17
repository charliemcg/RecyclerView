package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<String> items;
    Context context;

    public RecyclerAdapter(ArrayList<String> items, Context context) {
        //getting the data to be displayed
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    //inflating an item layout for each item. These views are going to be populated with item data
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    //This is where interaction with the layout elements occur. eg setting text to TextViews etc.
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(items.get(i));
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, items.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    //Getting total number of items
    public int getItemCount() {
        return items.size();
    }

    //getting the layout elements such as TextViews etc.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout layout;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.itemLayout);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
