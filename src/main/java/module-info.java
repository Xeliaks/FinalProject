module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
    exports com.example.finalproject.scenes;
    opens com.example.finalproject.scenes to javafx.fxml;
}