package com.example.pays.service;

import com.example.pays.model.CountryModel;

import java.rmi.Remote;

public interface CountryService extends Remote {

    public CountryModel[] countries() throws Exception;


}
