module com.example.pays {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires java.rmi;
    requires java.net.http;

    opens com.example.pays;
    opens com.example.pays.server;
    opens com.example.pays.controller;


}