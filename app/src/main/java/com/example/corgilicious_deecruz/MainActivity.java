package com.example.corgilicious_deecruz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_startOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //clicker for "start order" on home screen
        btn_startOrder = findViewById(R.id.btn_startOrder);
        btn_startOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuScreen();
            }
        });
    }

    //loading Menu activity
    public void menuScreen(){
        Intent menu = new Intent(this, Menu.class);
        startActivity(menu);
    }
}