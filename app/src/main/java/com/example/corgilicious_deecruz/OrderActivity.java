package com.example.corgilicious_deecruz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    TextView tvOrderSummaryDetails, tvItemName, tvQuantity,tvTotalPrice; //TextView to display the total price

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Retrieve the item name, quantity, and total price from the previous activity
        String itemName = getIntent().getStringExtra("itemName");
        int quantity = getIntent().getIntExtra("quantity", 0);
        double totalPrice = getIntent().getDoubleExtra("totalPrice", 0.00);

        // Initialize the TextViews to display the order details
        tvOrderSummaryDetails = findViewById(R.id.tv_orderSummaryDetails);
        tvItemName = findViewById(R.id.tv_itemName);
        tvQuantity = findViewById(R.id.tv_quantity);
        tvTotalPrice = findViewById(R.id.tv_total_price);

        // Set the values of the TextViews
        tvItemName.setText("Item: " + itemName);
        tvQuantity.setText("Quantity: " + quantity);
        tvTotalPrice.setText("Total Price: $" + String.format("%.2f", totalPrice));
    }
}