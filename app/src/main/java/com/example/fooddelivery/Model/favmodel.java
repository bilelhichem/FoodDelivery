package com.example.fooddelivery.Model;

public class favmodel {
    public   String nameprod, prodimg  ;
    public   String prodid ;
    public int prix ;

    public favmodel(String nameprod, String prodimg, String prodid, int prix) {
        this.nameprod = nameprod;
        this.prodimg = prodimg;
        this.prodid = prodid;
        this.prix = prix;
    }


    public favmodel() {
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

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
