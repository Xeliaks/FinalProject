package com.example.finalproject.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class QuizC {

    private Stage primaryStage;

    public QuizC(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene createScene() {
        AppMenuBar appMenuBar = new AppMenuBar(primaryStage);
        MenuBar menuBar = appMenuBar.createMenuBar();
        appMenuBar.setOpenMenuItemDisabled(true);
        appMenuBar.setSaveMenuItemDisabled(true);

        Label titleLabel = new Label("Character");
        titleLabel.setFont(Font.font("Book Antiqua", 24));
        titleLabel.setAlignment(Pos.TOP_CENTER);
        titleLabel.setStyle("-fx-text-fill: white;");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        for (int i = 0; i < 6; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / 6);
            gridPane.getColumnConstraints().add(column);
        }

        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 7);
            gridPane.getRowConstraints().add(row);
        }
        RowConstraints lastRow = new RowConstraints();
        lastRow.setPercentHeight(200.0 / 7);
        gridPane.getRowConstraints().add(lastRow);

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-text-fill: white;");
        TextField nameField = new TextField();
        nameField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        nameField.setPrefWidth(100);
        VBox nameBox = new VBox(10, nameLabel, nameField);

        Label levelLabel = new Label("Level:");
        levelLabel.setStyle("-fx-text-fill: white;");
        TextField levelField = new TextField();
        levelField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        levelField.setPrefWidth(20);
        VBox levelBox = new VBox(10, levelLabel, levelField);

        Button randomizeButton = new Button("Randomize");

        Label ancestryLabel = new Label("Ancestry:");
        ancestryLabel.setStyle("-fx-text-fill: white;");
        TextField ancestryField = new TextField();
        ancestryField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        ancestryField.setPrefWidth(100);
        VBox ancestryBox = new VBox(10, ancestryLabel, ancestryField);

        Label backgroundLabel = new Label("Background:");
        backgroundLabel.setStyle("-fx-text-fill: white;");
        TextField backgroundField = new TextField();
        backgroundField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        backgroundField.setPrefWidth(100);
        VBox backgroundBox = new VBox(10, backgroundLabel, backgroundField);

        Label classLabel = new Label("Class:");
        classLabel.setStyle("-fx-text-fill: white;");
        TextField classField = new TextField();
        classField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        classField.setPrefWidth(100);
        VBox classBox = new VBox(10, classLabel, classField);

        Label strLabel = new Label("STR:");
        strLabel.setStyle("-fx-text-fill: white;");
        TextField strField = new TextField();
        strField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        strField.setPrefWidth(20);
        VBox strBox = new VBox(10, strLabel, strField);

        Label dexLabel = new Label("DEX:");
        dexLabel.setStyle("-fx-text-fill: white;");
        TextField dexField = new TextField();
        dexField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        dexField.setPrefWidth(20);
        VBox dexBox = new VBox(10, dexLabel, dexField);

        Label conLabel = new Label("CON:");
        conLabel.setStyle("-fx-text-fill: white;");
        TextField conField = new TextField();
        conField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        conField.setPrefWidth(20);
        VBox conBox = new VBox(10, conLabel, conField);

        Label intLabel = new Label("INT:");
        intLabel.setStyle("-fx-text-fill: white;");
        TextField intField = new TextField();
        intField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        intField.setPrefWidth(20);
        VBox intBox = new VBox(10, intLabel, intField);

        Label wisLabel = new Label("WIS:");
        wisLabel.setStyle("-fx-text-fill: white;");
        TextField wisField = new TextField();
        wisField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        wisField.setPrefWidth(20);
        VBox wisBox = new VBox(10, wisLabel, wisField);

        Label chaLabel = new Label("CHA:");
        chaLabel.setStyle("-fx-text-fill: white;");
        TextField chaField = new TextField();
        chaField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        chaField.setPrefWidth(20);
        VBox chaBox = new VBox(10, chaLabel, chaField);

        Label alignmentLabel = new Label("Alignment:");
        alignmentLabel.setStyle("-fx-text-fill: white;");
        TextField alignmentField = new TextField();
        alignmentField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        alignmentField.setPrefWidth(100);
        VBox alignmentBox = new VBox(10, alignmentLabel, alignmentField);

        Label acLabel = new Label("AC:");
        acLabel.setStyle("-fx-text-fill: white;");
        TextField acField = new TextField();
        acField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        acField.setPrefWidth(20);
        VBox acBox = new VBox(10, acLabel, acField);

        Label hpLabel = new Label("HP:");
        hpLabel.setStyle("-fx-text-fill: white;");
        TextField hpField = new TextField();
        hpField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        hpField.setPrefWidth(20);
        VBox hpBox = new VBox(10, hpLabel, hpField);

        Label speedLabel = new Label("Speed:");
        speedLabel.setStyle("-fx-text-fill: white;");
        TextField speedField = new TextField();
        speedField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        speedField.setPrefWidth(20);
        VBox speedBox = new VBox(10, speedLabel, speedField);

        Label perceptionLabel = new Label("Perception:");
        perceptionLabel.setStyle("-fx-text-fill: white;");
        TextField perceptionField = new TextField();
        perceptionField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        perceptionField.setPrefWidth(20);
        VBox perceptionBox = new VBox(10, perceptionLabel, perceptionField);

        Label attackLabel = new Label("Attack:");
        attackLabel.setStyle("-fx-text-fill: white;");
        TextField attackField = new TextField();
        attackField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        attackField.setPrefWidth(20);
        VBox attackBox = new VBox(10, attackLabel, attackField);

        Label bioLabel = new Label("Bio:");
        bioLabel.setStyle("-fx-text-fill: white;");
        TextArea bioArea = new TextArea();
        bioArea.setStyle("-fx-control-inner-background: black; -fx-text-fill: white;");
        bioArea.setPrefWidth(900); // Half of the scene width (1800 / 2)
        bioArea.setPrefHeight(500); // Set a reasonable height for both elements
        VBox bioBox = new VBox(10, bioLabel, bioArea);

        Image uploadImage = new Image("file:src/main/images/UPicButton.png");
        ImageView uploadPictureButton = new ImageView(uploadImage);
        uploadPictureButton.setFitWidth(150);
        uploadPictureButton.setFitHeight(150);
        uploadPictureButton.setPreserveRatio(true);
        uploadPictureButton.setStyle("-fx-cursor: hand;");

        uploadPictureButton.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                try {
                    Image selectedImage = new Image(new FileInputStream(selectedFile));
                    double currentWidth = uploadPictureButton.getFitWidth();
                    double currentHeight = uploadPictureButton.getFitHeight();
                    uploadPictureButton.setFitWidth(currentWidth * 2);
                    uploadPictureButton.setFitHeight(currentHeight * 2);
                    uploadPictureButton.setImage(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        gridPane.add(nameBox, 0, 0);
        gridPane.add(levelBox, 1, 0);
        gridPane.add(randomizeButton, 5, 0);

        gridPane.add(ancestryBox, 0, 1);
        gridPane.add(backgroundBox, 2, 1);
        gridPane.add(classBox, 4, 1);

        gridPane.add(strBox, 0, 2);
        gridPane.add(dexBox, 1, 2);
        gridPane.add(conBox, 2, 2);
        gridPane.add(intBox, 3, 2);
        gridPane.add(wisBox, 4, 2);
        gridPane.add(chaBox, 5, 2);

        gridPane.add(alignmentBox, 0, 3);
        gridPane.add(acBox, 1, 3);
        gridPane.add(hpBox, 2, 3);

        gridPane.add(perceptionBox, 0, 4);
        gridPane.add(speedBox, 1, 4);
        gridPane.add(attackBox, 2, 4);

        gridPane.add(bioBox, 0, 5, 3, 1);
        gridPane.add(uploadPictureButton, 4, 5, 3, 1);

        VBox vbox = new VBox(0, menuBar, titleLabel, gridPane);
        vbox.setAlignment(Pos.TOP_CENTER);




        Scene scene = new Scene(vbox, 1800, 1000);

        Image backgroundImage = new Image("file:src/main/images/quizCBackground.png");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.DEFAULT.getWidth(),
                        BackgroundSize.DEFAULT.getHeight(),
                        false, false, false, false)
        );
        vbox.setBackground(new Background(background));


        bioArea.prefWidthProperty().bind(scene.widthProperty().divide(4));
        bioArea.prefHeightProperty().bind(scene.heightProperty().divide(4));
        uploadPictureButton.fitWidthProperty().bind(scene.widthProperty().divide(4));
        uploadPictureButton.fitHeightProperty().bind(scene.heightProperty().divide(4));

        return scene;
    }
}


