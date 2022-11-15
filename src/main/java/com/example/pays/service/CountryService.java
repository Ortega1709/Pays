package com.example.pays.service;

import com.example.pays.model.CountryModel;

import java.rmi.Remote;
import java.util.List;

public interface CountryService extends Remote {

    public List<CountryModel> countries() throws Exception;


}
