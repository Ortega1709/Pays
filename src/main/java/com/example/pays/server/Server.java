package com.example.pays.server;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

class Server {
    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("countryService", new CountryServiceImplement());

    }
}