package com.example.pays.server;


import com.example.pays.model.CountryModel;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

class Server {
    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("countryService", new CountryServiceImplement());


    }
}