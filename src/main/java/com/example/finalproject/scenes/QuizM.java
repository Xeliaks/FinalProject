package com.example.finalproject.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class QuizM {

    private Stage primaryStage;

    public QuizM(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene createScene() {
        AppMenuBar appMenuBar = new AppMenuBar(primaryStage);
        MenuBar menuBar = appMenuBar.createMenuBar();
        appMenuBar.setOpenMenuItemDisabled(true);
        appMenuBar.setSaveMenuItemDisabled(true);

        Label quizMLabel = new Label("QuizM Scene");
        StackPane root = new StackPane(quizMLabel);
        return new Scene(root, 1800, 1000);
    }
}
