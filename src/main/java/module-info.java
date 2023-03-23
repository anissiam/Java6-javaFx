module com.example.javafxg6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxg6 to javafx.fxml;
    exports com.example.javafxg6;
}