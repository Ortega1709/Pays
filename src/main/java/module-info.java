module com.example.pays {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires java.rmi;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.pays;
    opens com.example.pays.server;
    opens com.example.pays.model;
    opens com.example.pays.service;
    opens com.example.pays.controller;


}