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

public class Browser {
    private Scene scene;

    public Browser(CharacterC character) {
        Label titleLabel = new Label("Character");
        titleLabel.setFont(Font.font("Book Antiqua", 24));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(new Image(character.getImageLinkC()));
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);

        TextArea characterDetails = new TextArea();
        characterDetails.setEditable(false);
        characterDetails.setText(
                "Name: " + character.getNameC() + "\n" +
                        "Level: " + character.getLevelC() + "\n" +
                        "Ancestry: " + character.getAncestryC() + "\n" +
                        "Background: " + character.getBackgroundC() + "\n" +
                        "Class: " + character.getCharacterClassC() + "\n" +
                        "Strength: " + character.getStrengthC() + "\n" +
                        "Dexterity: " + character.getDexterityC() + "\n" +
                        "Constitution: " + character.getConstitutionC() + "\n" +
                        "Intelligence: " + character.getIntelligenceC() + "\n" +
                        "Wisdom: " + character.getWisdomC() + "\n" +
                        "Charisma: " + character.getCharismaC() + "\n" +
                        "Alignment: " + character.getAlignmentC() + "\n" +
                        "Armor Class: " + character.getArmorClassC() + "\n" +
                        "Hit Points: " + character.getHitPointsC() + "\n" +
                        "Perception: " + character.getPerceptionC() + "\n" +
                        "Speed: " + character.getSpeedC() + "\n" +
                        "Attack: " + character.getAttackC() + "\n" +
                        "Bio: " + character.getBioC() + "\n"
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
