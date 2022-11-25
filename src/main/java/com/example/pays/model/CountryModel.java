package com.example.pays.model;


import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.io.Serializable;

public class CountryModel implements Serializable{

    private boolean independent;

    private String cca3;
    private double area;

    private Long population;
    private String region;
    private List<String> capital;
    private FlagsModel flags;
    private TranslationsModel translations;
    private List<String> borders;
    private MapsModel maps;
    private List<String> continents;
    private DemonymsModel demonyms;


    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }

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

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public FlagsModel getFlags() {
        return flags;
    }

    public void setFlags(FlagsModel flagsModels) {
        this.flags = flagsModels;
    }

    public TranslationsModel getTranslations() {
        return translations;
    }

    public void setTranslations(TranslationsModel translations) {
        this.translations = translations;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public MapsModel getMaps() {
        return maps;
    }

    public void setMaps(MapsModel maps) {
        this.maps = maps;
    }

    public List<String> getContinents() {
        return continents;
    }

    public void setContinents(List<String> continents) {
        this.continents = continents;
    }

    public DemonymsModel getDemonyms() {
        return demonyms;
    }

    public void setDemonyms(DemonymsModel demonyms) {
        this.demonyms = demonyms;
    }
}

