package com.example.pays.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FraDeModel implements Serializable {
    private String m;
    private String f;

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }
}
