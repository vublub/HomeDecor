package com.example.computershop;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.computershop.Models.Users;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Profile extends AppCompatActivity {
    Button notification, cart, orders;
    BottomNavigationView menuNavigateProfile;
    ImageView profileImage;
    TextView username;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile);
        getCurrentUser();
        notification = findViewById(R.id.notification_btn);
        cart = findViewById(R.id.cart_btn);
        orders= findViewById(R.id.orders_btn);
        username = findViewById(R.id.username);
        profileImage = findViewById(R.id.profileImage);
        menuNavigateProfile = findViewById(R.id.navigatMenuProfile);
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
            Intent intent = new Intent(Profile.this, ShopList.class);
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

    private void getCurrentUser(){
        Supabase supabase = new Supabase();
        supabase.FetchCurrentUser(new Supabase.SBC_Callback() {
            @Override
            public void onFailure(IOException e) {
                runOnUiThread(() -> {
                    Log.e("getCurrentUser:onFailure", e.getLocalizedMessage());
                });
            }
            @Override
            public void onResponse(String responseBody) {
                runOnUiThread(() -> {
                    Log.e("getCurrentUser:onResponse", responseBody);
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Users>>() {}.getType();
                    List<Users> userlist = gson.fromJson(responseBody, type);
                    String url = "https://uzlmkofcyywierqzefku.supabase.co/storage/v1/object/public/avatars/";
                    if (userlist != null && !userlist.isEmpty()){
                        String loggedInUserId = DataBinding.getUuidUser();
                        Users profile = null;
                        for (Users u : userlist) {
                            if (u.getId().equals(loggedInUserId)) {
                                profile = u;
                                break;
                            }
                        }
                        String getav = profile.getAvatar_url();
                        Glide.with(Profile.this)
                                .load(url + getav)
                                .placeholder(R.drawable.profile)
                                .error(R.drawable.profile)
                                .into(profileImage);
                        username.setText(profile.getFullname());
                    }
                });
            }
        });
    }
}