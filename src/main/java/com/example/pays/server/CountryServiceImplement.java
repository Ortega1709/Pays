package com.example.pays.server;

import com.example.pays.model.CountryModel;
import com.example.pays.service.CountryService;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CountryServiceImplement extends UnicastRemoteObject implements CountryService {


    public CountryServiceImplement() throws RemoteException {
        super();
    }

    @Override
    public void countries() throws IOException, InterruptedException, URISyntaxException {
        System.out.println("Country");
        Gson gson = new Gson();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://restcountries.com/v3.1/all"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
    }

}
