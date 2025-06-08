package com.example.computershop;

public class MyOrdersHistoryItem_Class {
    public MyOrdersHistoryItem_Class(String orderNumber, String trackNumber) {
        this.orderNumber = orderNumber;
        this.trackNumber = trackNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String orderNumber;
    public String trackNumber;
}
