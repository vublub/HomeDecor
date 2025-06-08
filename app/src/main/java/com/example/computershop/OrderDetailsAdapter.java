package com.example.computershop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailsViewHolder> {
    ArrayList<OrderDetails_Class> tovarsInOrder;
    Context context;
    public OrderDetailsAdapter(ArrayList<OrderDetails_Class> tovarsInOrder, Context context){
        this.tovarsInOrder = tovarsInOrder;
        this.context = context;
    }
    @NonNull
    @Override
    public OrderDetailsAdapter.OrderDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemTovar = inflater.inflate(R.layout.item_order_details, parent, false);
        return new OrderDetailsAdapter.OrderDetailsViewHolder(itemTovar);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailsAdapter.OrderDetailsViewHolder holder, int position) {
        OrderDetails_Class orders = tovarsInOrder.get(position);
        holder.nameOfTovarCon.setText(orders.getNameOfTovar());
        holder.priceOfTovarCon.setText(orders.getPriceOfTovar());
    }

    @Override
    public int getItemCount() {
        return tovarsInOrder.size();
    }

    public class OrderDetailsViewHolder extends RecyclerView.ViewHolder {
        public TextView nameOfTovarCon;
        public TextView priceOfTovarCon;
        public OrderDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfTovarCon = itemView.findViewById(R.id.nameOfTovarId);
            priceOfTovarCon = itemView.findViewById(R.id.priceOfTovarId);
        }
    }
}
