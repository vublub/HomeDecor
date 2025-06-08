package com.example.computershop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    ArrayList<NotificationsItem_Class> notificArray;
    Context context;
    public NotificationAdapter(ArrayList<NotificationsItem_Class> notificArray, Context context){
        this.notificArray = notificArray;
        this.context = context;
    }
    @NonNull
    @Override
    public NotificationAdapter.NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemNoyific = inflater.inflate(R.layout.item_notific, parent, false);
        return new NotificationViewHolder(itemNoyific);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationViewHolder holder, int position) {
        NotificationsItem_Class notifics = notificArray.get(position);
        holder.nameNotific.setText(notifics.getNotificText());
        holder.dateTimeNotific.setText(notifics.getDateAndTimeNotific());
    }

    @Override
    public int getItemCount() {
        return notificArray.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        public TextView nameNotific;
        public TextView dateTimeNotific;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            nameNotific = itemView.findViewById(R.id.notificText);
            dateTimeNotific = itemView.findViewById(R.id.dateTimeNotific);
        }
    }
}
