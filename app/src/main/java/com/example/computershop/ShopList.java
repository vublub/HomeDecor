package com.example.computershop;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopList extends AppCompatActivity {
    ToggleButton filterForPrice, filterForAlphabet;
    TextView nameOfCategory;
    RecyclerView recyclerShopList;
    BottomNavigationView menuNavigateShopList;
    Button returnFronShopList;
    List<YourCart_Class> prodArrList;
    List<YourCart_Class> filteredProductList;
    YourCartAdapter yourCartAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.shop_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.shopListId), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        returnFronShopList = findViewById(R.id.ruturnFromShopList);
        filterForPrice = findViewById(R.id.filterPrice);
        filterForAlphabet = findViewById(R.id.filterAlphabet);
        nameOfCategory = findViewById(R.id.changeCategory);
        recyclerShopList = findViewById(R.id.recyclerShopList);
        menuNavigateShopList = findViewById(R.id.navigatMenuShopList);
        menuNavigateShopList.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        returnFronShopList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopList.this, ShopPage.class);
                startActivity(intent);
            }
        });
        prodArrList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerShopList.setLayoutManager(layoutManager);
        yourCartAdapt = new YourCartAdapter(prodArrList, getApplicationContext(), this::onItemClick);
        recyclerShopList.setAdapter(yourCartAdapt);
        filteredProductList = new ArrayList<>(prodArrList);
        filterForPrice.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                filterByPrice();
            } else {
                showAllProducts();
            }
        });
        filterForAlphabet.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (!filterForPrice.isChecked()) {
                    sortByAlphabet();
                } else {
                    Toast.makeText(ShopList.this, "Нельзя сортировать по алфавиту и фильтровать по цене одновременно", Toast.LENGTH_SHORT).show();
                    filterForAlphabet.setChecked(false);
                }
            } else {
                if (!filterForPrice.isChecked()) {
                    showAllProducts();
                }else {
                    yourCartAdapt.setProducts(filteredProductList);
                }
            }
        });
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainpage) {
            Intent intent = new Intent(ShopList.this, ShopPage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.orders) {
            Intent intent = new Intent(ShopList.this, MyOrdersHistory.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.sales) {
            Intent intent = new Intent(ShopList.this, Discounts.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    public void onItemClick(YourCart_Class product, int position) {
        Intent intent = new Intent(ShopList.this, ProductDetails.class);
        startActivity(intent);
    }

    private void filterByPrice() {
        int priceThreshold = 100;
        filteredProductList = (ArrayList<YourCart_Class>) prodArrList.stream()
                .filter(product -> {
                    try {
                        int price = product.getPriceYourCart();
                        return price > priceThreshold;
                    } catch (NumberFormatException e) {
                        Log.e("YourActivity", "Ошибка при парсинге цены: " + product.getPriceYourCart());
                        return false;
                    }
                })
                .collect(Collectors.toList());
        yourCartAdapt.setProducts(filteredProductList);
        updateRecyclerView();
    }
    private void showAllProducts() {
        filteredProductList.clear();
        filteredProductList.addAll(prodArrList);
        yourCartAdapt.setProducts(prodArrList);
        updateRecyclerView();
    }
    private void updateRecyclerView() {
        yourCartAdapt.notifyDataSetChanged();
    }
    private void sortByAlphabet() {
        if (filteredProductList != null) {
            Collections.sort(filteredProductList, new Comparator<YourCart_Class>() {
                @Override
                public int compare(YourCart_Class product1, YourCart_Class product2) {
                    if (product1 != null && product1.getNameYourCart() != null && product2 != null && product2.getNameYourCart() != null) {
                        return product1.getNameYourCart().compareTo(product2.getNameYourCart());
                    } else if (product1 != null && product1.getNameYourCart() != null) {
                        return -1;
                    } else if (product2 != null && product2.getNameYourCart() != null) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            updateRecyclerView();
        }
    }
}
