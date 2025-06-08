package com.example.computershop;

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

public class YourCart extends AppCompatActivity {
    Button returnToOrderHis, proceedToCKout;
    TextView totalYourcart;
    RecyclerView recyclerYourCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.yourcart_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.yourCartId), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        returnToOrderHis = findViewById(R.id.ruturnToOrderHisFromCart);
        proceedToCKout = findViewById(R.id.proceedtoCKout);
        totalYourcart = findViewById(R.id.totalSumYourCart);
        recyclerYourCart = findViewById(R.id.recyclerYorCart);
        returnToOrderHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YourCart.this, MyOrdersHistory.class);
                startActivity(intent);
            }
        });
        proceedToCKout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //передача данных в историю заказа
                Intent intent = new Intent(YourCart.this, MyOrdersHistory.class);
                startActivity(intent);
            }
        });
        ArrayList<YourCart_Class> prodArr = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerYourCart.setLayoutManager(layoutManager);
        YourCartAdapter yourCartAdapt = new YourCartAdapter(prodArr, getApplicationContext(), this::onItemClick);
        recyclerYourCart.setAdapter(yourCartAdapt);
    }
    public void onItemClick(YourCart_Class product, int position) {
        Intent intent = new Intent(YourCart.this, ProductDetails.class);
        startActivity(intent);
    }
}
