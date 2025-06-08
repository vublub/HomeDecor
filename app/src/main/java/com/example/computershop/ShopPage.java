package com.example.computershop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ShopPage extends AppCompatActivity {
    Button returnback, configuration, motherboard, proseccor, videocard, ram, coolers, harddrive, cases, netcard, soundcard;
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
        configuration = findViewById(R.id.configurations);
        motherboard = findViewById(R.id.matPlata);
        proseccor = findViewById(R.id.processor);
        videocard = findViewById(R.id.videoCard);
        ram = findViewById(R.id.ram);
        coolers = findViewById(R.id.cooler);
        harddrive = findViewById(R.id.harddrive);
        cases = findViewById(R.id.caseComp);
        netcard = findViewById(R.id.netcard);
        soundcard = findViewById(R.id.soundcard);
        menuNavigate = findViewById(R.id.navigatMenu);
        menuNavigate.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
    }
    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.returntosignin){
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.configurations) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.matPlata) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.processor) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.videoCard) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.ram) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.cooler) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.harddrive) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.caseComp) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.netcard) {
            Intent intent = new Intent(ShopPage.this, SignIn.class);
            startActivity(intent);
        } else if (id == R.id.soundcard) {
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
            Intent intent = new Intent(ShopPage.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(ShopPage.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.sales) {
            Intent intent = new Intent(ShopPage.this, Discounts.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
