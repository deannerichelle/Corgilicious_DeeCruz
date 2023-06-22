package com.example.corgilicious_deecruz;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    ImageView imgV_ube_latte, imgV_cappuccino, imgV_oreo_frappe, imgV_corgi_sticker;
    Button btnCart;

    ArrayList<CartItem> cartItems = new ArrayList<>();

    private ActivityResultLauncher<Intent> cartActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        // Retrieve the updated cartItems list from the DetailsActivity
                        ArrayList<CartItem> updatedCartItems = result.getData().getParcelableArrayListExtra("cartItems");
                        if (updatedCartItems != null) {
                            cartItems = updatedCartItems;
                            Toast.makeText(Menu.this, "Item added to cart!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imgV_ube_latte = findViewById(R.id.imgV_ube_latte);
        imgV_cappuccino = findViewById(R.id.imgV_cappuccino);
        imgV_oreo_frappe = findViewById(R.id.imgV_oreo_frappe);
        imgV_corgi_sticker = findViewById(R.id.imgV_corgi_sticker);

        btnCart = findViewById(R.id.btn_cart);

        imgV_ube_latte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 0;
                detailsScreen(id);
            }
        });

        imgV_cappuccino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 1;
                detailsScreen(id);
            }
        });

        imgV_oreo_frappe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 2;
                detailsScreen(id);
            }
        });

        imgV_corgi_sticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 3;
                detailsScreen(id);
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartIntent = new Intent(Menu.this, CartActivity.class);
                cartIntent.putParcelableArrayListExtra("cartItems", cartItems);
                startActivity(cartIntent);
            }
        });

        // Check if there are any updated cartItems received from the CartActivity
        if (getIntent().hasExtra("cartItems")) {
            ArrayList<CartItem> updatedCartItems = getIntent().getParcelableArrayListExtra("cartItems");
            if (updatedCartItems != null) {
                cartItems = updatedCartItems;
            }
        }

    }
    public void detailsScreen(int id){
        Intent details = new Intent(Menu.this, Details.class);
        details.putExtra("id", id);
        cartActivityResultLauncher.launch(details);
    }
}