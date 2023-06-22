package com.example.corgilicious_deecruz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    TextView tvOrderSummary,tvCartItems, tvTotalPrice, tvTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ArrayList<CartItem> cartItems = getIntent().getParcelableArrayListExtra("cartItems");

        tvOrderSummary = findViewById(R.id.tv_orderSummary);
        tvCartItems = findViewById(R.id.tv_cart_items);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        tvTax = findViewById(R.id.tv_tax);

        StringBuilder sb = new StringBuilder();
        double subtotal = 0.0;
        double taxRate = 10.5; // Tax rate in percentage

        for (CartItem item : cartItems) {
            sb.append(item.getItemName()).append(" - Quantity: ").append(item.getQuantity()).append("\n");
            subtotal += item.getPrice(); // Accumulate the individual item prices
        }

        double tax = (subtotal * taxRate) / 100;
        double totalWithTax = subtotal + tax;

        tvCartItems.setText(sb.toString());
        tvTax.setText("Item Price: $" + String.format("%.2f", subtotal) + "\nTax: $" + String.format("%.2f", tax));
        tvTotalPrice.setText("Total Price: $" + String.format("%.2f", totalWithTax));

        Button btnBackToMenu = findViewById(R.id.btnBackToMenu);
        btnBackToMenu.setOnClickListener(view -> {
            // Create an intent to go back to the menu activity
            Intent menuIntent = new Intent(CartActivity.this, Menu.class);
            menuIntent.putParcelableArrayListExtra("cartItems", cartItems);
            startActivity(menuIntent);
        });

        //this will clear the items from the cart
        Button btnCancelOrder = findViewById(R.id.btn_cancelOrder);
        btnCancelOrder.setOnClickListener(view -> {
            // Clear the cart by removing all items
            cartItems.clear();

            // Create an intent to go back to the MainActivity
            Intent mainIntent = new Intent(CartActivity.this, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear all previous activities
            startActivity(mainIntent);
        });
    }
}
