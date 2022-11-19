package com.example.pays.controller;

import com.example.pays.server.CountryServiceImplement;
import com.example.pays.service.CountryService;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.SecurityPermission;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    private Stage stage;
    private double yOffset;
    private double xOffset;

    @FXML
    public MFXFontIcon btnClose;

    @FXML
    public HBox windowHeader;

    public ClientController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnClose.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
        windowHeader.setOnMousePressed(event -> {
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });
        windowHeader.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://restcountries.com/v3.1/all"))
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(new String(httpResponse.body().getBytes(), "UTF-8"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
