package com.example.computershop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MyOrdersHistory extends AppCompatActivity {
    BottomNavigationView menuNavigateOrderHis;
    RecyclerView recyclerMyOrders;
    ImageButton cartOrders, notificImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.my_orders_history_layput);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.myorderslayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        menuNavigateOrderHis = findViewById(R.id.navigatMenuOrders);
        menuNavigateOrderHis.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        cartOrders = findViewById(R.id.cartButton);
        notificImg = findViewById(R.id.notificFromOrders);
        recyclerMyOrders = findViewById(R.id.recyclerMyOrders);
        ArrayList<MyOrdersHistoryItem_Class> ordersArray = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerMyOrders.setLayoutManager(layoutManager);
        MyOrdersHistoryAdapter ordersAdapt = new MyOrdersHistoryAdapter(ordersArray, getApplicationContext());
        recyclerMyOrders.setAdapter(ordersAdapt);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(MyOrdersHistory.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(MyOrdersHistory.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.sales) {
            Intent intent = new Intent(MyOrdersHistory.this, Discounts.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.notificFromOrders){
            Intent intent = new Intent(MyOrdersHistory.this, Notifications_Main.class);
            startActivity(intent);
        } else if (id == R.id.cartButton) {
            Intent intent = new Intent(MyOrdersHistory.this, YourCart.class);
            startActivity(intent);
        }
    }
}
