package com.example.pays.server;

import com.example.pays.model.CountryModel;
import com.example.pays.service.CountryService;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;

public class CountryServiceImplement extends UnicastRemoteObject implements CountryService {


    public CountryServiceImplement() throws RemoteException {
        super();
    }

    @Override
    public CountryModel[] countries() throws Exception {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://restcountries.com/v3.1/all"))
                .timeout(Duration.ofMinutes(1))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();

        HttpResponse<String> completableFuture = HttpClient.newBuilder()
                .build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        CountryModel[] countryModel = new Gson()
                .fromJson(completableFuture.body(), CountryModel[].class);

        return countryModel;

    }

}
