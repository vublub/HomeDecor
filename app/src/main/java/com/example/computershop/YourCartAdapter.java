package com.example.computershop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class YourCartAdapter extends RecyclerView.Adapter<YourCartAdapter.YourcartViewHolder> {
    List<YourCart_Class> productArray;
    Context context;
    private final OnItemClickListener itemClickListener;
    public YourCartAdapter(List<YourCart_Class> productArray, Context context, OnItemClickListener itemClickListener) {
        this.productArray = productArray;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(YourCart_Class product, int position);
    }

    @NonNull
    @Override
    public YourCartAdapter.YourcartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.item_shop_page, parent, false);
        return new YourcartViewHolder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull YourCartAdapter.YourcartViewHolder holder, int position) {
        YourCart_Class product = productArray.get(position);
        holder.productImg.setImageResource(product.getImageYourCart());
        holder.productName.setText(product.getNameYourCart());
        holder.productPrice.setText(product.getPriceYourCart());
        int positionNew = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(product, positionNew);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArray.size();
    }

    public class YourcartViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImg;
        public TextView productName;
        public TextView productPrice;
        public YourcartViewHolder(@NonNull View itemView) {
            super(itemView);
            productImg = itemView.findViewById(R.id.imageItemShopPage);
            productName = itemView.findViewById(R.id.nameOfItem);
            productPrice = itemView.findViewById(R.id.priceOfItem);
        }
    }
    public void setProducts(List<YourCart_Class> newProducts) {
        productArray.clear();
        if (newProducts != null) {
            productArray.addAll(newProducts);
        }
        notifyDataSetChanged();
    }
}
