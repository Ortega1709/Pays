module com.example.pays {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pays to javafx.fxml;
    exports com.example.pays;
}