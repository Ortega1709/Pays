package com.example.pays.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FraModel implements Serializable {
    private String official;
    private String common;

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }
}
