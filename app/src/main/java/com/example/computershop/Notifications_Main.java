package com.example.computershop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Notifications_Main extends AppCompatActivity {
    Button returnToMain;
    RecyclerView recyclerNotific;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.notification_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.notific_lay), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        returnToMain = findViewById(R.id.returnyomainpage);
        returnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notifications_Main.this, ShopPage.class);
                startActivity(intent);
            }
        });
        recyclerNotific = findViewById(R.id.recyclerNotifications);
        ArrayList<NotificationsItem_Class> notificArray = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerNotific.setLayoutManager(layoutManager);
        NotificationAdapter notificAdapt = new NotificationAdapter(notificArray, getApplicationContext());
        recyclerNotific.setAdapter(notificAdapt);
    }
}
