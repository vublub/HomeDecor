package com.example.computershop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.computershop.Kitchen;
import com.example.computershop.Models.Product;
import com.example.computershop.R;

import java.util.List;

public class KitchenAdapter extends RecyclerView.Adapter<KitchenAdapter.ViewHolder> {
    private Context context;
    private List<Product> productList;
    public KitchenAdapter(Context context, List<Product> productList){
        this.context = context;
        this.productList = productList;
    }
    @NonNull
    @Override
    public KitchenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shop_page, parent, false);
        return new KitchenAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KitchenAdapter.ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.priceOfItem.setText(product.getPrice());
        holder.nameOfItem.setText(product.getName());
        String url = "https://uzlmkofcyywierqzefku.supabase.co/storage/v1/object/public/imageproducts/";
        Glide.with(context)
                .load(url + product.getImage_urls())
                .into(holder.imageItemShopPage);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView priceOfItem, nameOfItem;
        ImageView imageItemShopPage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            priceOfItem = itemView.findViewById(R.id.priceOfItem);
            nameOfItem = itemView.findViewById(R.id.nameOfItem);
            imageItemShopPage = itemView.findViewById(R.id.imageItemShopPage);
        }
    }
}
