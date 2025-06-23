package com.example.computershop;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.computershop.Adapters.KitchenAdapter;
import com.example.computershop.Adapters.ProductAdapter;
import com.example.computershop.Models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Kitchen extends AppCompatActivity {
    RecyclerView recKitchen;
    BottomNavigationView menuNavigate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.kitchen);
        getKitchen();
        menuNavigate = findViewById(R.id.navigatMenuCategory);
        menuNavigate.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        recKitchen = findViewById(R.id.recKitchen);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(Kitchen.this, ShopList.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.categories) {
            Intent intent = new Intent(Kitchen.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(Kitchen.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.wishlist) {
            Intent intent = new Intent(Kitchen.this, YourCart.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.profile) {
            Intent intent = new Intent(Kitchen.this, Profile.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    private void getKitchen(){
        Supabase supabase = new Supabase();
        supabase.fetchKitchen(new Supabase.SBC_Callback() {
            @Override
            public void onFailure(IOException e) {
                runOnUiThread(() -> {
                    Log.e("getKitchen:onFailure", e.getLocalizedMessage());
                });
            }

            @Override
            public void onResponse(String responseBody) {
                runOnUiThread(() -> {
                    Log.e("getKitchen:onResponse", responseBody);
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Product>>() {
                    }.getType();
                    List<Product> productList = gson.fromJson(responseBody, type);
                    KitchenAdapter kitchenAdapter = new KitchenAdapter(getApplicationContext(), productList);
                    recKitchen.setAdapter(kitchenAdapter);
                    recKitchen.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                });
            }
        });
    }
}
