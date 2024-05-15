package com.example.finalproject.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CollectionM {

    private Scene scene;

    public CollectionM(Stage primaryStage) {
        AppMenuBar appMenuBar = new AppMenuBar(primaryStage);
        MenuBar menuBar = appMenuBar.createMenuBar();

        BorderPane root = new BorderPane();
        Label label = new Label("Monster Collection");
        root.setTop(menuBar);
        root.setCenter(label);

        this.scene = new Scene(root, 1800, 1000);
    }

    public Scene getScene() {
        return this.scene;
    }
}

