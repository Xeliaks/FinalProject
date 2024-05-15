package com.example.finalproject.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CollectionC {

    private Scene scene;

    public CollectionC(Stage primaryStage) {
        AppMenuBar appMenuBar = new AppMenuBar(primaryStage);
        MenuBar menuBar = appMenuBar.createMenuBar();

        BorderPane root = new BorderPane();
        Label label = new Label("Character Collection");
        root.setTop(menuBar);
        root.setCenter(label);

        this.scene = new Scene(root, 1800, 1000);
    }

    public Scene getScene() {
        return this.scene;
    }
}