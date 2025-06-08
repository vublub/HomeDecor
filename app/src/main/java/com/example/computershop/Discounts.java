package com.example.computershop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

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

public class Discounts extends AppCompatActivity {
    BottomNavigationView menuNavigateDis;
    RecyclerView recyclerDiscounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sales_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sales_lay), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        menuNavigateDis = findViewById(R.id.navigatMenusales);
        menuNavigateDis.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        recyclerDiscounts = findViewById(R.id.recyclerDiscounts);
        ArrayList<DiscountsItem_Class> discountArray = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerDiscounts.setLayoutManager(layoutManager);
        DiscountAdapter discountAdapt = new DiscountAdapter(discountArray, getApplicationContext());
        recyclerDiscounts.setAdapter(discountAdapt);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(Discounts.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(Discounts.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.sales) {
            Intent intent = new Intent(Discounts.this, Discounts.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
