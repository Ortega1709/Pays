package com.example.pays.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TranslationsModel implements Serializable {
    private FraModel fra;

    public FraModel getFra() {
        return fra;
    }

    public void setFra(FraModel fra) {
        this.fra = fra;
    }
}
