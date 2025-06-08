package com.example.computershop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {
    Button returnToOrderHistory, continueShopping;
    TextView orderNumTV, orderNumLittleTV, trackNumTV, paymentTV, totalTV;
    RecyclerView recyclerOrderDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.order_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.orderDetailsLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        returnToOrderHistory = findViewById(R.id.returntoOrderHistory);
        continueShopping = findViewById(R.id.continueToShopPage);
        orderNumTV = findViewById(R.id.orderNumberDeteils);
        orderNumLittleTV = findViewById(R.id.orderNemberDetailsLittle);
        trackNumTV = findViewById(R.id.trackingNumberDetails);
        paymentTV = findViewById(R.id.paymentDetails);
        totalTV = findViewById(R.id.totalSumDetails);
        recyclerOrderDetails = findViewById(R.id.recyclerOrderDetails);
        returnToOrderHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDetails.this, MyOrdersHistory.class);
                startActivity(intent);
            }
        });
        ArrayList<OrderDetails_Class> orderArray = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerOrderDetails.setLayoutManager(layoutManager);
        OrderDetailsAdapter orderAdapt = new OrderDetailsAdapter(orderArray, getApplicationContext());
        recyclerOrderDetails.setAdapter(orderAdapt);
    }
}
