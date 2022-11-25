package com.example.pays.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MapsModel implements Serializable {
    private String googleMaps;
    private String openStreetMaps;

    public String getGoogleMaps() {
        return googleMaps;
    }

    public void setGoogleMaps(String googleMaps) {
        this.googleMaps = googleMaps;
    }

    public String getOpenStreetMaps() {
        return openStreetMaps;
    }

    public void setOpenStreetMaps(String openStreetMaps) {
        this.openStreetMaps = openStreetMaps;
    }
}
