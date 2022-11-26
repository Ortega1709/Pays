package com.example.pays.controller;

import com.example.pays.model.CountryModel;
import com.example.pays.service.CountryService;
import com.google.gson.Gson;
import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.materialfx.controls.cell.MFXListCell;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.Duration;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    private Stage stage;
    private double yOffset;
    private double xOffset;
    public ObservableList<CountryModel> countries;
    @FXML
    public MFXFontIcon btnClose;
    @FXML
    public HBox windowHeader;
    @FXML
    public ImageView imageViewDetails;
    @FXML
    public Label officialName;
    @FXML
    public Label commonName;
    @FXML
    public Label capitalName;
    @FXML
    public Label continentName;
    @FXML
    public MFXScrollPane listViewDetail;
    @FXML
    public MFXListView<String> listViewBorder;
    @FXML
    public MFXListView<CountryModel> listCountry;
    @FXML
    public Label nbrPopulation;
    @FXML
    public Label area;
    @FXML
    public Label independent;
    @FXML
    public Label population;
    @FXML
    public MFXTextField searchBar;
    @FXML
    public BorderPane homePane;
    @FXML
    public Pane detailsPane;
    @FXML
    public MFXButton btnBack;

    // constructor
    public ClientController(Stage stage) {
        this.stage = stage;
    }

    // initializer
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        moveScreen();

        initializeImageClip();

        try {
            initializeData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // move screen
    void moveScreen() {

        btnClose.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
        windowHeader.setOnMousePressed(event -> {
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });
        windowHeader.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });

    }

    @FXML
    void onClickBack(ActionEvent event) {
        btnBack.setVisible(false);
        homePane.setVisible(true);
        detailsPane.setVisible(false);
    }

    // function select item
    @FXML
    void onClickItem(MouseEvent event) {

        btnBack.setVisible(true);
        homePane.setVisible(false);
        detailsPane.setVisible(true);
        listViewDetail.setVisible(false);
        this.displayDetailsData(listCountry.getSelectionModel().getSelectedValues().get(0));
        listViewDetail.setVisible(true);

    }


    // initialize rounded image in detail view
     void initializeImageClip() {

        Rectangle rectangle = new Rectangle(
                imageViewDetails.getFitWidth(), imageViewDetails.getFitHeight()
        );

        rectangle.setArcHeight(13);
        rectangle.setArcWidth(13);
        imageViewDetails.setClip(rectangle);

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Paint.valueOf("#0f2633"));
        Image image = new Image("https://flagcdn.com/w320/cd.png");
        imageViewDetails.setImage(image);

    }

    // fetch data from api of countries
     void initializeData() throws Exception {

        LocateRegistry.getRegistry("192.168.50.163", 1099);
        CountryService countryService = (CountryService) Naming.lookup("countryInfo");
        CountryModel[] countryModels = countryService.countries();

        this.countries= FXCollections.observableArrayList(countryModels);
        StringConverter<CountryModel> converter = FunctionalStringConverter
                .to(countryModel -> (countryModel == null) ? "" :
                        countryModel
                                .getTranslations()
                                .getFra()
                                .getCommon());

        // create a filter list
        FilteredList<CountryModel> filteredList = new FilteredList<>(this.countries, p -> true);

        listCountry.setItems(filteredList);
        listCountry.setConverter(converter);
        listCountry.setCellFactory(countryModel -> new CountryModelCellFactory(listCountry, countryModel));
        listCountry.features().enableBounceEffect();

        // filter search bar
        searchBar.textProperty().addListener((obs, oldValue, newValue) -> {
             filteredList.setPredicate(p -> p
                     .getTranslations()
                     .getFra()
                     .getCommon()
                     .toLowerCase()
                     .contains(newValue
                             .toLowerCase()
                             .trim()));
         });

    }

    // display details data
     void displayDetailsData(CountryModel countryModel) {

        Image image = new Image(countryModel.getFlags().getPng());
        imageViewDetails.setImage(image);

        officialName.setText(countryModel.getTranslations().getFra().getOfficial());
        commonName.setText(countryModel.getTranslations().getFra().getCommon());

        capitalName.setText(countryModel
                .getCapital() != null ? countryModel.getCapital().get(0): countryModel.getTranslations().getFra().getCommon());

        nbrPopulation.setText(countryModel.getPopulation().toString());
        area.setText(String.valueOf(countryModel.getArea()));
        population.setText(
                countryModel.getDemonyms()
                        .getFra() == null
                        ? countryModel.getDemonyms().getEng().getM() : countryModel.getDemonyms().getFra().getM());

        independent.setText(String.valueOf(countryModel.isIndependent()));
        continentName.setText(toFrenchContinent(countryModel.getContinents().get(0)));

        if (countryModel.getBorders() != null) {
            ObservableList<String> borders = FXCollections.observableArrayList(countryModel.getBorders());
            listViewBorder.setItems(borders);
        }

    }

    // convert continent's name in French
     String toFrenchContinent(String continent) {

        return continent.equals("Asia")
                ? "Asie": continent.equals("Africa")
                ? "Afrique": continent.equals("Europe")
                ? "Europe": continent.equals("South America")
                ? "Amérique du sud": continent.equals("North America")
                ? "Amérique du nord": continent.equals("Oceania")
                ? "Océanie": "";

    }

    private static class CountryModelCellFactory extends MFXListCell<CountryModel> {
        private final MFXFontIcon flagIcon;

        public CountryModelCellFactory(MFXListView<CountryModel> listView, CountryModel data) {
            super(listView, data);

            flagIcon = new MFXFontIcon("mfx-map", 0);
            flagIcon.setColor(Color.TRANSPARENT);
            render(data);
        }

        @Override
        protected void render(CountryModel data) {
            super.render(data);
            if (flagIcon != null) getChildren().add(0, flagIcon);
        }
    }

}
