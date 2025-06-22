package com.example.computershop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

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
        recyclerDiscounts = findViewById(R.id.recyclerDiscounts);
        ArrayList<DiscountsItem_Class> discountArray = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerDiscounts.setLayoutManager(layoutManager);
        DiscountAdapter discountAdapt = new DiscountAdapter(discountArray, getApplicationContext());
        recyclerDiscounts.setAdapter(discountAdapt);
    }
    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.backOnProfile){
            Intent intent = new Intent(Discounts.this, Profile.class);
            startActivity(intent);}
    }
}
