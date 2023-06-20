package com.example.corgilicious_deecruz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity implements View.OnClickListener{

    ImageView imgVCoffeeImg;
    TextView tvCoffeeName, tvItemDetails, tvTotalAmount;
    Button btnAdd, btnAmount, btnRemove, btnAddToOrder;

    String[] menuItems = {"Ube Latte", "Cappuccino", "Oreo Frappuccino", "Corgi Stickers"};
    String[] menuDetails = {"This creamy and colorful ube latte is sweet and refreshing! Ube extract is mixed with ice and almond milk, then topped with strong espresso." + "\n" +
            "Calories: 280",
            "This is an espresso drink with equal parts steamed milk of your choice, milk foam and espresso." + "\n" +
                    "Calories: 80",
            "A sweet treat made with rich chocolate flavor, a hint of coffee and OREO® Cookie Pieces. It's blended with ice then hand topped with whipped light cream and a few more OREO® Cookie Pieces." + "\n" +
                    "Calories: 550",
            "Purchase one of our adorable Corgi stickers. The corgi images itself are swapped with new ones every month!"};
    int[] menuImages = {R.drawable.ube_latte, R.drawable.cappuccino, R.drawable.oreo_frappe, R.drawable.corgi_sticker};
    int amount = 0;
    double itemPrice = 8.00; //price per item
    double totalPrice = 0.00; //total price

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgVCoffeeImg = findViewById(R.id.imgV_coffeeImg); //this should show the image of each menu item
        tvCoffeeName = findViewById(R.id.tv_coffee_name); //this should show the name of each menu item
        tvItemDetails = findViewById(R.id.tv_itemDetails); //this should show the details of each menu item
        tvTotalAmount = findViewById(R.id.tv_total_amount);

        btnAdd = findViewById(R.id.btn_add);
        btnAmount = findViewById(R.id.btn_amount);
        btnRemove = findViewById(R.id.btn_remove);
        btnAddToOrder = findViewById(R.id.btn_addToOrder);

        btnAdd.setOnClickListener(this);
        btnAmount.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnAddToOrder.setOnClickListener(this);

        btnAmount.setText(String.valueOf(amount));

        int getId = getIntent().getIntExtra("id", 0);
        imgVCoffeeImg.setImageResource(menuImages[getId]);
        tvCoffeeName.setText(menuItems[getId]);
        tvItemDetails.setText(menuDetails[getId]);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_add:
                amount = amount + 1;
                totalPrice = amount * itemPrice;
                btnAmount.setText(String.valueOf(amount));
                tvTotalAmount.setText("Total: $" + String.format("%.2f", totalPrice));
                break;
            case R.id.btn_remove:
                amount = amount - 1;
                if (amount < 0) {
                    amount = 0;
                } else {
                    totalPrice = amount * itemPrice;
                }
                btnAmount.setText(String.valueOf(amount));
                tvTotalAmount.setText("Total: $" + String.format("%.2f", totalPrice));
                break;
            case R.id.btn_addToOrder:
                int getId = getIntent().getIntExtra("id", 0);
                Intent orderSummaryIntent = new Intent(Details.this, OrderActivity.class);
                orderSummaryIntent.putExtra("itemName", menuItems[getId]);
                orderSummaryIntent.putExtra("quantity", amount);
                orderSummaryIntent.putExtra("totalPrice", totalPrice);
                startActivity(orderSummaryIntent);
                break;
        }
    }
}