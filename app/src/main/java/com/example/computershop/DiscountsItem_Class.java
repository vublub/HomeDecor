package com.example.computershop;

public class DiscountsItem_Class {
    public DiscountsItem_Class(String persantOfDiscount, String nameOfDiscount) {
        this.persantOfDiscount = persantOfDiscount;
        this.nameOfDiscount = nameOfDiscount;
    }

    public String getPersantOfDiscount() {
        return persantOfDiscount;
    }

    public void setPersantOfDiscount(String persantOfDiscount) {
        this.persantOfDiscount = persantOfDiscount;
    }

    public String getNameOfDiscount() {
        return nameOfDiscount;
    }

    public void setNameOfDiscount(String nameOfDiscount) {
        this.nameOfDiscount = nameOfDiscount;
    }

    String persantOfDiscount;
    String nameOfDiscount;
}
