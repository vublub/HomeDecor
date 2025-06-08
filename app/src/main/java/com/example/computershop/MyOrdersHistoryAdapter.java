package com.example.computershop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrdersHistoryAdapter extends RecyclerView.Adapter<MyOrdersHistoryAdapter.MyOrderViewHolder> {
    ArrayList<MyOrdersHistoryItem_Class> ordersArray;
    Context context;
    public MyOrdersHistoryAdapter(ArrayList<MyOrdersHistoryItem_Class> ordersArray, Context context){
        this.ordersArray = ordersArray;
        this.context = context;
    }
    public interface OnOrderItemClickListener {
        void onOrderItemClick(MyOrdersHistoryItem_Class order, int position, Context context);
    }
    @NonNull
    @Override
    public MyOrdersHistoryAdapter.MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemMyOrder = inflater.inflate(R.layout.item_myorders_history, parent, false);
        return new MyOrdersHistoryAdapter.MyOrderViewHolder(itemMyOrder);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersHistoryAdapter.MyOrderViewHolder holder, int position) {
        MyOrdersHistoryItem_Class orders = ordersArray.get(position);
        holder.orderNum.setText(orders.getOrderNumber());
        holder.trackNum.setText(orders.getTrackNumber());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderDetails.class);
                //intent.putExtra("order", order);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ordersArray.size();
    }

    public class MyOrderViewHolder extends RecyclerView.ViewHolder {
        public TextView orderNum;
        public TextView trackNum;
        public Button button;
        public MyOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderNum = itemView.findViewById(R.id.orderNumber);
            trackNum = itemView.findViewById(R.id.trackNumber);
            button = itemView.findViewById(R.id.buttonDetails);
        }
    }
}
