package com.example.pays.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DemonymsModel implements Serializable {

    private EngDeModel eng;

    private FraDeModel fra;

    public EngDeModel getEng() {
        return eng;
    }

    public void setEng(EngDeModel eng) {
        this.eng = eng;
    }

    public FraDeModel getFra() {
        return fra;
    }

    public void setFra(FraDeModel fra) {
        this.fra = fra;
    }
}
