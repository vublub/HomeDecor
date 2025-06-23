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

import com.example.computershop.Adapters.BathroomAdapter;
import com.example.computershop.Models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Bathroom extends AppCompatActivity {
    RecyclerView recBathroom;
    BottomNavigationView menuNavigate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bathroom);
        getBathroom();
        recBathroom = findViewById(R.id.recBathroom);
        menuNavigate = findViewById(R.id.navigatMenuCategory);
        menuNavigate.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(Bathroom.this, ShopList.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.categories) {
            Intent intent = new Intent(Bathroom.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(Bathroom.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.wishlist) {
            Intent intent = new Intent(Bathroom.this, YourCart.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.profile) {
            Intent intent = new Intent(Bathroom.this, Profile.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    private void getBathroom(){
        Supabase supabase = new Supabase();
        supabase.fetchBathroom(new Supabase.SBC_Callback() {
            @Override
            public void onFailure(IOException e) {
                runOnUiThread(() -> {
                    Log.e("getBathroom:onFailure", e.getLocalizedMessage());
                });
            }

            @Override
            public void onResponse(String responseBody) {
                runOnUiThread(() -> {
                    Log.e("getBathroom:onResponse", responseBody);
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Product>>() {
                    }.getType();
                    List<Product> productList = gson.fromJson(responseBody, type);
                    BathroomAdapter bathroomAdapter = new BathroomAdapter(getApplicationContext(), productList);
                    recBathroom.setAdapter(bathroomAdapter);
                    recBathroom.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                });
            }
        });
    }
}