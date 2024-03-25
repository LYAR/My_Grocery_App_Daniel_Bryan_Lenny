package com.example.mygroceryapp;

import static com.example.mygroceryapp.MainActivity.listOfCarts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mygroceryapp.models.CartModel;
import com.example.mygroceryapp.models.ItemsModel;

public class ItemDetailsActivity extends AppCompatActivity {
    TextView tvLabel, tvId, tvName, tvDesc, tvPrice;
    ImageView ivImage;
    EditText etQuantity;
    ImageView ivBack;
    AppCompatButton btnAddToCart, btnDelete;
    String from = "";
    ItemsModel itemsModel;
    CartModel cartModel;
    int position = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.main_color));
        ivBack = findViewById(R.id.ivBack);
        tvLabel = findViewById(R.id.tvLabel);
        tvId = findViewById(R.id.tvId);
        tvName = findViewById(R.id.tvName);
        tvDesc = findViewById(R.id.tvDesc);
        tvPrice = findViewById(R.id.tvPrice);
        etQuantity = findViewById(R.id.etQuantity);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnDelete = findViewById(R.id.btnDelete);
        ivImage = findViewById(R.id.ivImage);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (getIntent().getExtras() != null) {
            from = getIntent().getStringExtra("from");
            if (from.equals("cart")) {
                position = getIntent().getIntExtra("position", 0);
                cartModel = (CartModel) getIntent().getSerializableExtra("data");
                tvId.setText("Item Id: " + cartModel.getItem_id());
                tvName.setText("Item Name: " + cartModel.getName());
                tvDesc.setText("Item Desc: " + cartModel.getDesc());
                tvPrice.setText("Item Price: " + cartModel.getPrice());
                etQuantity.setText(cartModel.getQuantity());
                etQuantity.setFocusable(false);
                btnAddToCart.setVisibility(View.GONE);
                btnDelete.setVisibility(View.VISIBLE);
                setImage(Integer.parseInt(cartModel.getItem_id()));
            } else {
                itemsModel = (ItemsModel) getIntent().getSerializableExtra("data");
                tvId.setText(String.valueOf("Item Id: " + itemsModel.getId()));
                tvName.setText("Item Name: " + itemsModel.getName());
                tvDesc.setText("Item Desc: " + itemsModel.getDesc());
                tvPrice.setText("Item Price: " + itemsModel.getPrice());
                btnDelete.setVisibility(View.GONE);
                setImage(itemsModel.getId());
            }
        }

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listOfCarts.remove(position);
                Toast.makeText(ItemDetailsActivity.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = etQuantity.getText().toString();
                if (quantity.isEmpty()) {
                    Toast.makeText(ItemDetailsActivity.this, "Please enter quantity", Toast.LENGTH_SHORT).show();
                    return;
                }

                CartModel model = new CartModel(String.valueOf(itemsModel.getId()), itemsModel.getName(), itemsModel.getDesc(), quantity, itemsModel.getPrice());
                listOfCarts.add(model);
                Toast.makeText(ItemDetailsActivity.this, "Successfully Added to Cart", Toast.LENGTH_SHORT).show();
                finish();


            }
        });

    }

    private void setImage(int image) {
        switch (image) {
            case 1:
                ivImage.setImageResource(R.drawable.chicken);
                break;
            case 2:
                ivImage.setImageResource(R.drawable.fish);
                break;
            case 3:
                ivImage.setImageResource(R.drawable.milk);
                break;
            case 4:
                ivImage.setImageResource(R.drawable.potatoes);
                break;
            case 5:
                ivImage.setImageResource(R.drawable.spinach);
                break;
            case 6:
                ivImage.setImageResource(R.drawable.eggs);
                break;
            case 7:
                ivImage.setImageResource(R.drawable.bread);
                break;
            case 8:
                ivImage.setImageResource(R.drawable.tissues);
                break;
            case 9:
                ivImage.setImageResource(R.drawable.water);
                break;
            case 10:
                ivImage.setImageResource(R.drawable.juice);
                break;
        }
    }
}