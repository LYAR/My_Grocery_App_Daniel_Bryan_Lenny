package com.example.mygroceryapp;

import static com.example.mygroceryapp.MainActivity.listOfCarts;
import static com.example.mygroceryapp.MainActivity.listOfOrders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mygroceryapp.adapter.CartAdapter;
import com.example.mygroceryapp.models.CartModel;
import com.example.mygroceryapp.models.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ImageView ivBack;
    RecyclerView rvItems;
    AppCompatButton btnPlaceOrder;
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.main_color));

        ivBack = findViewById(R.id.ivBack);
        rvItems = findViewById(R.id.rvItems);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!listOfCarts.isEmpty()){
                    for (int i=0; i<listOfCarts.size(); i++){
                        CartModel cartModel = listOfCarts.get(i);
                        OrderModel model = new OrderModel(cartModel.getItem_id(), cartModel.getName(), cartModel.getDesc(), cartModel.getQuantity(), cartModel.getPrice());
                        listOfOrders.add(model);
                    }
                    listOfCarts.clear();
                    Toast.makeText(CartActivity.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();

        if (listOfCarts.isEmpty()){
            btnPlaceOrder.setVisibility(View.GONE);
        }
        adapter = new CartAdapter(listOfCarts, this);
        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItems.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}