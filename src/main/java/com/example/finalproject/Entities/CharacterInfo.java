package com.example.finalproject.Entities;

import com.example.finalproject.scenes.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CharacterInfo extends VBox {
    private CharacterC character;
    private Stage primaryStage;

    public CharacterInfo(CharacterC character, Stage primaryStage) {
        this.character = character;
        this.primaryStage = this.primaryStage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);


        HBox imageBox = new HBox();
        ImageView imageView = new ImageView();
        Image image = new Image("file:" + character.getImageLinkC());
        imageView.setImage(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageBox.getChildren().add(imageView);
        imageBox.setAlignment(Pos.CENTER);

        HBox infoBox = new HBox(10);
        Label nameLabel = new Label("Name: " + character.getNameC());
        Label levelLabel = new Label("Level: " + character.getLevelC());
        nameLabel.setTextFill(Color.WHITE);
        levelLabel.setTextFill(Color.WHITE);
        infoBox.getChildren().addAll(nameLabel, levelLabel);
        infoBox.setAlignment(Pos.CENTER);

        HBox classBox = new HBox();
        Label classLabel = new Label("Class: " + character.getCharacterClassC());
        classLabel.setTextFill(Color.WHITE);
        classBox.getChildren().add(classLabel);
        classBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(imageBox, infoBox, classBox);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: black;");


        this.setOnMouseClicked((MouseEvent event) -> {
            Browser browserScene = new Browser(character);
            this.primaryStage.setScene(browserScene.getScene());
        });
    }
}
