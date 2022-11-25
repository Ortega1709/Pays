package com.example.pays.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public void startServer(String ip_address, int port) {

        try {
            LocateRegistry.createRegistry(port);
            Registry registry = LocateRegistry.getRegistry(ip_address, port);
            registry.rebind("countryInfo", new CountryServiceImplement());
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }

    public void stopServer() {
        try {
            LocateRegistry.createRegistry(0);
            LocateRegistry.getRegistry("", 0);
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }

}
