package com.example.computershop;

public class NotificationsItem_Class {
    public NotificationsItem_Class(String notificText, String dateAndTimeNotific) {
        this.notificText = notificText;
        this.dateAndTimeNotific = dateAndTimeNotific;
    }

    public String getNotificText() {
        return notificText;
    }

    public void setNotificText(String notificText) {
        this.notificText = notificText;
    }

    public String getDateAndTimeNotific() {
        return dateAndTimeNotific;
    }

    public void setDateAndTimeNotific(String dateAndTimeNotific) {
        this.dateAndTimeNotific = dateAndTimeNotific;
    }
    public String notificText;
    public String dateAndTimeNotific;
}
