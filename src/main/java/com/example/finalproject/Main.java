package com.example.finalproject;

import com.example.finalproject.scenes.BaseScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BaseScene baseScene = new BaseScene(primaryStage);
        Scene scene = baseScene.createScene();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Character and Monster Creator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}