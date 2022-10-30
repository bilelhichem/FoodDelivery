package com.example.fooddelivery.Model;

public class getprod {
    public String nameprod ,prodimg;
    public int prix ;

    public getprod() {
    }

    public getprod(String nameprod, String prodimg, int prix) {
        this.nameprod = nameprod;
        this.prodimg = prodimg;
        this.prix = prix;
    }

    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    public String getProdimg() {
        return prodimg;
    }

    public void setProdimg(String prodimg) {
        this.prodimg = prodimg;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
