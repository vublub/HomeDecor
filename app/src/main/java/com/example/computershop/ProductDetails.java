package com.example.computershop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetails extends AppCompatActivity {
    Button returnToShopList, addToCart;
    TextView nameOfPr, priceOfPr, descriptionOfPr;
    ImageView imageOfPr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.product_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.productDetailsId), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        returnToShopList = findViewById(R.id.returnToToShopList);
        addToCart = findViewById(R.id.butAddTocart);
        nameOfPr = findViewById(R.id.nameOfProducrDetails);
        priceOfPr = findViewById(R.id.priceOfProducrDetails);
        descriptionOfPr = findViewById(R.id.descriptionOfProducrDetails);
        imageOfPr = findViewById(R.id.imageOfProductDetails);
        returnToShopList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetails.this, ShopList.class);
                startActivity(intent);
            }
        });
    }
}
