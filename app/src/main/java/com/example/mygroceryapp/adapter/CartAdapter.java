package com.example.mygroceryapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mygroceryapp.ItemDetailsActivity;
import com.example.mygroceryapp.R;
import com.example.mygroceryapp.models.CartModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    List<CartModel> list;
    Context context;

    public CartAdapter(List<CartModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ItemsAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        CartModel model = list.get(position);
        holder.tvId.setText("Item Id: " + model.getItem_id());
        holder.tvName.setText("Item Name: " + model.getName());
        holder.tvDesc.setText("Item Quantity: " + model.getQuantity());
        holder.tvPrice.setText("Item Price: " + String.valueOf(model.getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra("from", "cart");
                intent.putExtra("data", model);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });

        switch (Integer.parseInt(model.getItem_id())){
            case 1:
                holder.ivImage.setImageResource(R.drawable.chicken);
                break;
            case 2:
                holder.ivImage.setImageResource(R.drawable.fish);
                break;
            case 3:
                holder.ivImage.setImageResource(R.drawable.milk);
                break;
            case 4:
                holder.ivImage.setImageResource(R.drawable.potatoes);
                break;
            case 5:
                holder.ivImage.setImageResource(R.drawable.spinach);
                break;
            case 6:
                holder.ivImage.setImageResource(R.drawable.eggs);
                break;
            case 7:
                holder.ivImage.setImageResource(R.drawable.bread);
                break;
            case 8:
                holder.ivImage.setImageResource(R.drawable.tissues);
                break;
            case 9:
                holder.ivImage.setImageResource(R.drawable.water);
                break;
            case 10:
                holder.ivImage.setImageResource(R.drawable.juice);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
