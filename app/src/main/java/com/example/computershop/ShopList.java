package com.example.computershop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.computershop.Adapters.ProductAdapter;
import com.example.computershop.Models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopList extends AppCompatActivity {
    TextView goToCategory;
    RecyclerView recyclerShopList;
    BottomNavigationView menuNavigateShopList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.shop_list);
        getAllProducts();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.shopListId), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        goToCategory = findViewById(R.id.goToCategory);
        recyclerShopList = findViewById(R.id.recyclerShopList);
        menuNavigateShopList = findViewById(R.id.navigatMenuShopList);
        menuNavigateShopList.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        goToCategory.setOnClickListener(v -> startActivity(new Intent(this, ShopPage.class)));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(ShopList.this, ShopList.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.categories) {
            Intent intent = new Intent(ShopList.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(ShopList.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.wishlist) {
            Intent intent = new Intent(ShopList.this, YourCart.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.profile) {
            Intent intent = new Intent(ShopList.this, Profile.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    public void onItemClick(YourCart_Class product, int position) {
        Intent intent = new Intent(ShopList.this, ProductDetails.class);
        startActivity(intent);
    }
    private void getAllProducts(){
        Supabase supabase = new Supabase();
        supabase.fetchAllProduct(new Supabase.SBC_Callback() {
            @Override
            public void onFailure(IOException e) {
                runOnUiThread(() -> {
                    Log.e("getAllProducts:onFailure", e.getLocalizedMessage());
                });
            }

            @Override
            public void onResponse(String responseBody) {
                runOnUiThread(() -> {
                    Log.e("getAllProducts:onResponse", responseBody);
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Product>>() {
                    }.getType();
                    List<Product> productList = gson.fromJson(responseBody, type);
                    ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(), productList);
                    recyclerShopList.setAdapter(productAdapter);
                    recyclerShopList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                });
            }
        });
    }
}
