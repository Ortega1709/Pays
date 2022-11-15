package com.example.pays.service;

import com.example.pays.model.Country;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CountryService extends Remote {

    public List<Country> countries() throws RemoteException;


}
