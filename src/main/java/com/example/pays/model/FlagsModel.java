package com.example.pays.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlagsModel implements Serializable {
    private String png;
    private String svg;

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }
}
