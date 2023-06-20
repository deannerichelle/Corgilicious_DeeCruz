package com.example.corgilicious_deecruz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    TextView tvCartItems, tvTotalPrice, tvTax;
    double price = 0.0;
    double tax = 10.5;
    double totalWithTax = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ArrayList<CartItem> cartItems = getIntent().getParcelableArrayListExtra("cartItems");

        tvCartItems = findViewById(R.id.tv_cart_items);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        tvTax = findViewById(R.id.tv_tax);

        StringBuilder sb = new StringBuilder();


        for (CartItem item : cartItems) {
            sb.append(item.getItemName()).append(" - Quantity: ").append(item.getQuantity()).append("\n");
            price += item.getPrice() * item.getQuantity();
            tax = (price * 10.5) / 100;
            totalWithTax += (price + tax);
        }

        tvCartItems.setText(sb.toString());
        tvTax.setText("Item Price: $" + String.format("%.2f", price) + "\nTax: $" + String.format("%.2f", tax));
        tvTotalPrice.setText("Total Price: $" + String.format("%.2f", totalWithTax));

        Button btnBackToMenu = findViewById(R.id.btnBackToMenu);
        btnBackToMenu.setOnClickListener(view -> {
            // Create an intent to go back to the menu activity
            Intent menuIntent = new Intent(CartActivity.this, Menu.class);
            startActivity(menuIntent);
        });


    }
}

//still need to fix the cart button 