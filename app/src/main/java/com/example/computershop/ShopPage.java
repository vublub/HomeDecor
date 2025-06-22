package com.example.computershop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ShopPage extends AppCompatActivity {
    Button returnback, kitchen, livingRoom, bedroom, bathroom, office, diningRoom, decor;
    ImageButton notifications;
    BottomNavigationView menuNavigate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.shop_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.shoppage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        notifications = findViewById(R.id.notifications);
        returnback = findViewById(R.id.returntosignin);
        kitchen = findViewById(R.id.kitchen);
        livingRoom = findViewById(R.id.livingRoom);
        bedroom = findViewById(R.id.bedroom);
        bathroom = findViewById(R.id.bathroom);
        office = findViewById(R.id.office);
        diningRoom = findViewById(R.id.diningRoom);
        decor = findViewById(R.id.decor);
        menuNavigate = findViewById(R.id.navigatMenu);
        menuNavigate.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
    }
    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.returntosignin){
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.kitchen) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.livingRoom) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.bedroom) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.bathroom) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.office) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.diningRoom) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.decor) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.notifications) {
            Intent intent = new Intent(ShopPage.this, Notifications_Main.class);
            startActivity(intent);
        }
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(ShopPage.this, ShopList.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.categories) {
            Intent intent = new Intent(ShopPage.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(ShopPage.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.wishlist) {
            Intent intent = new Intent(ShopPage.this, YourCart.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.profile) {
            Intent intent = new Intent(ShopPage.this, Profile.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
