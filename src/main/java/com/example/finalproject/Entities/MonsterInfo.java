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

public class MonsterInfo extends VBox {
    private Monster monster;
    private Stage primaryStage;

    public MonsterInfo(Monster monster, Stage primaryStage) {
        this.monster = monster;
        this.primaryStage = primaryStage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        HBox imageBox = new HBox();
        ImageView imageView = new ImageView();
        Image image = new Image("file:" + monster.getImageLinkM());
        imageView.setImage(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageBox.getChildren().add(imageView);
        imageBox.setAlignment(Pos.CENTER);

        HBox infoBox = new HBox(10);
        Label nameLabel = new Label("Name: " + monster.getNameM());
        Label levelLabel = new Label("Level: " + monster.getLevelM());
        nameLabel.setTextFill(Color.WHITE);
        levelLabel.setTextFill(Color.WHITE);
        infoBox.getChildren().addAll(nameLabel, levelLabel);
        infoBox.setAlignment(Pos.CENTER);


        this.getChildren().addAll(imageBox, infoBox);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: black;");

        this.setOnMouseClicked((MouseEvent event) -> {
            MonsterBrowser monsterBrowserScene = new MonsterBrowser(monster, primaryStage);
            primaryStage.setScene(monsterBrowserScene.getScene());
        });
    }
}

