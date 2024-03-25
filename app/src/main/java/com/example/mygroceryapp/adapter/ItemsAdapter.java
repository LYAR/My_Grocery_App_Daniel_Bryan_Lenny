package com.example.mygroceryapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mygroceryapp.ItemDetailsActivity;
import com.example.mygroceryapp.R;
import com.example.mygroceryapp.models.ItemsModel;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{
    List<ItemsModel> list;
    Context context;

    public ItemsAdapter(List<ItemsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemsModel model = list.get(position);
        holder.tvId.setText("Item Id: "+model.getId());
        holder.tvName.setText("Item Name: "+model.getName());
        holder.tvDesc.setText("Item Desc: "+model.getDesc());
        holder.tvPrice.setText("Item Price: "+String.valueOf(model.getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra("from", "items");
                intent.putExtra("data", model);
                context.startActivity(intent);
            }
        });
        switch (position){
            case 0:
                holder.ivImage.setImageResource(R.drawable.chicken);
                break;
            case 1:
                holder.ivImage.setImageResource(R.drawable.fish);
                break;
            case 2:
                holder.ivImage.setImageResource(R.drawable.milk);
                break;
            case 3:
                holder.ivImage.setImageResource(R.drawable.potatoes);
                break;
            case 4:
                holder.ivImage.setImageResource(R.drawable.spinach);
                break;
            case 5:
                holder.ivImage.setImageResource(R.drawable.eggs);
                break;
            case 6:
                holder.ivImage.setImageResource(R.drawable.bread);
                break;
            case 7:
                holder.ivImage.setImageResource(R.drawable.tissues);
                break;
            case 8:
                holder.ivImage.setImageResource(R.drawable.water);
                break;
            case 9:
                holder.ivImage.setImageResource(R.drawable.juice);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvDesc, tvPrice;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
}
