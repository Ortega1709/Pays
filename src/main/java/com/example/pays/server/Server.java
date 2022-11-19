package com.example.pays.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public void startServer() {

        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("countryInfo", new CountryServiceImplement());
            System.out.println("Server started ...");
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }

}
