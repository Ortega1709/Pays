package com.example.pays.controller;

import com.example.pays.model.CountryModel;
import com.example.pays.server.CountryServiceImplement;
import com.example.pays.service.CountryService;
import com.google.gson.Gson;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
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
import java.util.concurrent.CompletableFuture;

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

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://restcountries.com/v3/all"))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();

        try{
            HttpResponse<String> completableFuture = HttpClient.newBuilder()
                    .build().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String newResponse = completableFuture.body().replaceAll("\\P{Print}", "");
            CountryModel[] countryModels = new Gson().fromJson(newResponse, CountryModel[].class);
            for (int i = 0; i < countryModels.length; i++)
                System.out.println(countryModels[i].getCca3());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
