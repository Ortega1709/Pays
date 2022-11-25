package com.example.pays.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.pays.server.*;
import javafx.scene.control.Label;

public class ServerController implements Initializable {

    @FXML
    public MFXTextField ipLabel;

    @FXML
    public MFXTextField portLabel;

    @FXML
    public MFXButton btnStart;

    @FXML
    public Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void onStartServer(ActionEvent event) {

        String ip_address = ipLabel.getText();
        int port = Integer.parseInt(portLabel.getText());

        if (ip_address.equals("") || port == 0) {
            statusLabel.setText("Error parsing ip address");
        } else {

            statusLabel.setText("Server starting ...");
            new Server().startServer(ip_address, port);
            statusLabel.setText("Server started ...");

        }
    }

    @FXML
    void onStopServer(ActionEvent event) {

        new Server().stopServer();
        statusLabel.setText("Server stopped");
    }


}
