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
import java.util.List;

public class CountryServiceImplement  implements CountryService {


    @Override
    public List<CountryModel> countries() throws Exception {

        Gson gson = new Gson();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://restcountries.com/v3.1/all"))
                .timeout(Duration.ofMinutes(2))
                .GET()
                .build();

        HttpClient httpClient =  HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        CountryModel[] countryModel = gson.fromJson(httpResponse.body(), CountryModel[].class);
        return List.of(countryModel);

    }
}
