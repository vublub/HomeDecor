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

import com.bumptech.glide.module.LibraryGlideModule;
import com.example.computershop.Adapters.KitchenAdapter;
import com.example.computershop.Adapters.LivingroomAdapter;
import com.example.computershop.Models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class LivingRoom extends AppCompatActivity {
    BottomNavigationView menuNavigate;
    RecyclerView recLivingroom;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.living_room);
        recLivingroom = findViewById(R.id.recLivingRoom);
        getLivingroom();
        menuNavigate = findViewById(R.id.navigatMenuCategory);
        menuNavigate.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(LivingRoom.this, ShopList.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.categories) {
            Intent intent = new Intent(LivingRoom.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(LivingRoom.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.wishlist) {
            Intent intent = new Intent(LivingRoom.this, YourCart.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.profile) {
            Intent intent = new Intent(LivingRoom.this, Profile.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    private void getLivingroom(){
        Supabase supabase = new Supabase();
        supabase.fetchLivingroom(new Supabase.SBC_Callback() {
            @Override
            public void onFailure(IOException e) {
                runOnUiThread(() -> {
                    Log.e("getLivingroom:onFailure", e.getLocalizedMessage());
                });
            }

            @Override
            public void onResponse(String responseBody) {
                runOnUiThread(() -> {
                    Log.e("getLivingroom:onResponse", responseBody);
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Product>>() {
                    }.getType();
                    List<Product> productList = gson.fromJson(responseBody, type);
                    LivingroomAdapter livingroomAdapter = new LivingroomAdapter(getApplicationContext(), productList);
                    recLivingroom.setAdapter(livingroomAdapter);
                    recLivingroom.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                });
            }
        });
    }
}
