package com.example.pays.model;


import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("independent")
    private boolean independent;

    @SerializedName("cca3")
    private String cca3;

    @SerializedName("area")
    private double area;

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }
}

