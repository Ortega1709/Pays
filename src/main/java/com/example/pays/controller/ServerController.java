package com.example.pays.controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.pays.server.*;

public class ServerController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Server server = new Server();
        server.startServer();
    }
}
