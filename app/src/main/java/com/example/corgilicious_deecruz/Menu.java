package com.example.corgilicious_deecruz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Menu extends AppCompatActivity {

    LottieAnimationView likeUbe, likeCappuccino, likeOreo, likeSticker;
    ImageView imgV_ube_latte, imgV_cappuccino, imgV_oreo_frappe, imgV_corgi_sticker;
    Button btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        likeUbe = findViewById(R.id.lav_heartAnimation_1);
        likeCappuccino = findViewById(R.id.lav_heartAnimation_2);
        likeOreo = findViewById(R.id.lav_heartAnimation_3);
        likeSticker = findViewById(R.id.lav_heartAnimation_4);

        imgV_ube_latte = findViewById(R.id.imgV_ube_latte);
        imgV_cappuccino = findViewById(R.id.imgV_cappuccino);
        imgV_oreo_frappe = findViewById(R.id.imgV_oreo_frappe);
        imgV_corgi_sticker = findViewById(R.id.imgV_corgi_sticker);

        btnCart = findViewById(R.id.btn_cart);

        likeUbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeUbe.setSelected(!likeUbe.isSelected()); // Toggle the selection state
                if (likeUbe.isSelected()) {
                    likeUbe.playAnimation();
                } else {
                    likeUbe.setProgress(0f); // Reset the animation to the beginning
                }
            }
        });

        likeCappuccino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeCappuccino.setSelected(!likeCappuccino.isSelected());
                if (likeCappuccino.isSelected()) {
                    likeCappuccino.playAnimation();
                } else {
                    likeCappuccino.setProgress(0f);
                }
            }
        });

        likeOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeOreo.setSelected(!likeOreo.isSelected());
                if (likeOreo.isSelected()) {
                    likeOreo.playAnimation();
                } else {
                    likeOreo.setProgress(0f);
                }
            }
        });

        likeSticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeSticker.setSelected(!likeSticker.isSelected());
                if (likeSticker.isSelected()) {
                    likeSticker.playAnimation();
                } else {
                    likeSticker.setProgress(0f);
                }
            }
        });


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
                Intent orderIntent = new Intent(Menu.this, OrderActivity.class);
                startActivity(orderIntent);
            }
        });
    }
    public void detailsScreen(int id){
        Intent details = new Intent(this, Details.class);
        details.putExtra("id", id);
        startActivity(details);
    }

}

//how to add a cart function where it will show all of the orders as a list