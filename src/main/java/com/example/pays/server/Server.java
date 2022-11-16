package com.example.pays.server;


import com.example.pays.model.CountryModel;

import java.util.List;

class Server {
    public static void main(String[] args) throws Exception {

        List<CountryModel> countryModels = new CountryServiceImplement().countries();
    }
}