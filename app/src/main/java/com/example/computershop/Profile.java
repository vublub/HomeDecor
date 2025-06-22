package com.example.computershop;
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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {
    BottomNavigationView menuNavigateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile);
        menuNavigateProfile = findViewById(R.id.navigatMenuOrders);
        menuNavigateProfile.setOnNavigationItemSelectedListener(this::onNavigationItemSelected); }

    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.notification_btn){
            Intent intent = new Intent(Profile.this, Notifications_Main.class);
            startActivity(intent);
        } else if (id == R.id.cart_btn) {
            Intent intent = new Intent(Profile.this, YourCart.class);
            startActivity(intent);}
        else if (id == R.id.orders_btn) {
            Intent intent = new Intent(Profile.this, MyOrdersHistory.class);
            startActivity(intent);}
    }
        
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(Profile.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.categories) {
            Intent intent = new Intent(Profile.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(Profile.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.wishlist) {
            Intent intent = new Intent(Profile.this, YourCart.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.profile) {
            Intent intent = new Intent(Profile.this, Profile.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}