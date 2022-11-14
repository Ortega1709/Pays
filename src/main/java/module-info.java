module com.example.pays {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires VirtualizedFX;


    opens com.example.pays to javafx.fxml;
    exports com.example.pays;
}