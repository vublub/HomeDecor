package com.example.computershop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.DiscountViewHolder> {
    ArrayList<DiscountsItem_Class> discountArray;
    Context context;
    public DiscountAdapter(ArrayList<DiscountsItem_Class> discountArray, Context context){
        this.discountArray = discountArray;
        this.context = context;
    }
    @NonNull
    @Override
    public DiscountAdapter.DiscountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemDiscount = inflater.inflate(R.layout.item_discounts, parent, false);
        return new DiscountAdapter.DiscountViewHolder(itemDiscount);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountAdapter.DiscountViewHolder holder, int position) {
        DiscountsItem_Class discounts = discountArray.get(position);
        holder.percantDiscount.setText(discounts.getPersantOfDiscount());
        holder.nameDiscount.setText(discounts.getNameOfDiscount());
    }

    @Override
    public int getItemCount() {
        return discountArray.size();
    }

    public class DiscountViewHolder extends RecyclerView.ViewHolder {
        public TextView percantDiscount;
        public TextView nameDiscount;
        public DiscountViewHolder(@NonNull View itemView) {
            super(itemView);
            percantDiscount = itemView.findViewById(R.id.persantOfDiscount);
            nameDiscount = itemView.findViewById(R.id.nameOfDiscount);
        }
    }
}
