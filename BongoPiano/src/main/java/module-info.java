module com.example.bongopiano {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bongopiano to javafx.fxml;
    exports com.example.bongopiano;
}