package com.example.mygroceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mygroceryapp.adapter.ItemsAdapter;
import com.example.mygroceryapp.models.ItemsModel;

import java.util.ArrayList;
import java.util.List;

public class GroceriesActivity extends AppCompatActivity {
    ImageView ivBack;
    RecyclerView rvItems;
    ItemsAdapter adapter;
    List<ItemsModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.main_color));
        ivBack = findViewById(R.id.ivBack);
        rvItems = findViewById(R.id.rvItems);
        setAdapter();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setAdapter(){
        list.clear();
        list.add(new ItemsModel( 1, R.drawable.chicken, "Chicken", "Meat", "9.99"));
        list.add(new ItemsModel(2, R.drawable.fish, "Fish", "Meat", "8.99"));
        list.add(new ItemsModel(3, R.drawable.milk, "Milk", "Diary", "1.99"));
        list.add(new ItemsModel(4,R.drawable.potatoes, "Potatoes", "Vegetables", "3.99"));
        list.add(new ItemsModel(5,R.drawable.spinach, "Spinach", "Vegetables", "4.99"));
        list.add(new ItemsModel(6,R.drawable.eggs, "Eggs", "Poultry", "15.99"));
        list.add(new ItemsModel(7, R.drawable.bread, "Bread", "Diary", "6.99"));
        list.add(new ItemsModel(8,R.drawable.tissues, "Tissues", "Dialy Needs", "7.99"));
        list.add(new ItemsModel(9, R.drawable.water, "Water", "Dialy Needs", "1.99"));
        list.add(new ItemsModel(10,R.drawable.juice, "Orange Juice", "Drinks", "2.99"));

        adapter = new ItemsAdapter(list, this);
        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItems.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}