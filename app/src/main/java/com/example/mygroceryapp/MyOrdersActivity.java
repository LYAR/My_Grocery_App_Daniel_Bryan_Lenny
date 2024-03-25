package com.example.mygroceryapp;

import static com.example.mygroceryapp.MainActivity.listOfOrders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mygroceryapp.adapter.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersActivity extends AppCompatActivity {
    ImageView ivBack;
    RecyclerView rvItems;
    OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.main_color));
        ivBack = findViewById(R.id.ivBack);
        rvItems = findViewById(R.id.rvItems);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();

        adapter = new OrderAdapter(listOfOrders, this);
        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItems.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}