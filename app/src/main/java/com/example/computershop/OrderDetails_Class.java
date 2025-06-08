package com.example.computershop;

public class OrderDetails_Class {
    public OrderDetails_Class(String nameOfTovar, int priceOfTovar) {
        this.nameOfTovar = nameOfTovar;
        this.priceOfTovar = priceOfTovar;
    }

    public String getNameOfTovar() {
        return nameOfTovar;
    }

    public void setNameOfTovar(String nameOfTovar) {
        this.nameOfTovar = nameOfTovar;
    }

    public int getPriceOfTovar() {
        return priceOfTovar;
    }

    public void setPriceOfTovar(int priceOfTovar) {
        this.priceOfTovar = priceOfTovar;
    }

    public String nameOfTovar;
    public int priceOfTovar;
}
