package com.example.computershop;

import android.media.Image;

public class YourCart_Class {
    public YourCart_Class(String nameYourCart, int priceYourCart, int imageYourCart) {
        this.nameYourCart = nameYourCart;
        this.priceYourCart = priceYourCart;
        this.imageYourCart = imageYourCart;
    }

    public String getNameYourCart() {
        return nameYourCart;
    }

    public void setNameYourCart(String nameYourCart) {
        this.nameYourCart = nameYourCart;
    }

    public int getPriceYourCart() {
        return priceYourCart;
    }

    public void setPriceYourCart(int priceYourCart) {
        this.priceYourCart = priceYourCart;
    }

    public int getImageYourCart() {
        return imageYourCart;
    }

    public void setImageYourCart(int imageYourCart) {
        this.imageYourCart = imageYourCart;
    }

    public String nameYourCart;
    public int priceYourCart;
    public int imageYourCart;
}
