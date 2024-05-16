package com.example.finalproject.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import com.example.finalproject.Entities.*;
import javafx.stage.Stage;

public class MonsterBrowser {
    private Scene scene;

    public MonsterBrowser(Monster monster, Stage primaryStage) {
        Label titleLabel = new Label("Monster");
        titleLabel.setFont(Font.font("Book Antiqua", 24));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(new Image(monster.getImageLinkM()));
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);

        TextArea characterDetails = new TextArea();
        characterDetails.setEditable(false);
        characterDetails.setText(
                "Name: " + monster.getNameM() + "\n" +
                        "Level: " + monster.getLevelM() + "\n" +
                        "Strength: " + monster.getStrengthM() + "\n" +
                        "Dexterity: " + monster.getDexterityM() + "\n" +
                        "Constitution: " + monster.getConstitutionM() + "\n" +
                        "Intelligence: " + monster.getIntelligenceM() + "\n" +
                        "Wisdom: " + monster.getWisdomM() + "\n" +
                        "Charisma: " + monster.getCharismaM() + "\n" +
                        "Alignment: " + monster.getAlignmentM() + "\n" +
                        "Armor Class: " + monster.getArmorClassM() + "\n" +
                        "Hit Points: " + monster.getHitPointsM() + "\n" +
                        "Perception: " + monster.getPerceptionM() + "\n" +
                        "Speed: " + monster.getSpeedM() + "\n" +
                        "Attack: " + monster.getAttackM() + "\n" +
                        "Bio: " + monster.getBioM() + "\n"
        );

        HBox contentBox = new HBox(20);
        contentBox.getChildren().addAll(imageView, characterDetails);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(titleLabel, contentBox);
        vbox.setStyle("-fx-background-color: black;");
        contentBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vbox);

        this.scene = new Scene(borderPane, 1800, 1000);
    }

    public Scene getScene() {
        return this.scene;
    }
}