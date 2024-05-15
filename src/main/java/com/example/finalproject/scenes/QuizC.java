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
        AppMenuBar appMenuBarC = new AppMenuBar(primaryStage);
        MenuBar menuBarC = appMenuBarC.createMenuBar();
        appMenuBarC.setOpenMenuItemDisabled(true);
        appMenuBarC.setSaveMenuItemDisabled(true);

        Label titleLabelC = new Label("Character");
        titleLabelC.setFont(Font.font("Book Antiqua", 24));
        titleLabelC.setAlignment(Pos.TOP_CENTER);
        titleLabelC.setStyle("-fx-text-fill: white;");

        GridPane gridPaneC = new GridPane();
        gridPaneC.setHgap(10);
        gridPaneC.setVgap(10);
        gridPaneC.setPadding(new Insets(10));

        for (int i = 0; i < 6; i++) {
            ColumnConstraints columnC = new ColumnConstraints();
            columnC.setPercentWidth(100.0 / 6);
            gridPaneC.getColumnConstraints().add(columnC);
        }

        for (int i = 0; i < 5; i++) {
            RowConstraints rowC = new RowConstraints();
            rowC.setPercentHeight(100.0 / 7);
            gridPaneC.getRowConstraints().add(rowC);
        }
        RowConstraints lastRowC = new RowConstraints();
        lastRowC.setPercentHeight(200.0 / 7);
        gridPaneC.getRowConstraints().add(lastRowC);

        Label nameLabelC = new Label("Name:");
        nameLabelC.setStyle("-fx-text-fill: white;");
        TextField nameFieldC = new TextField();
        nameFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        nameFieldC.setPrefWidth(100);
        VBox nameBoxC = new VBox(10, nameLabelC, nameFieldC);

        Label levelLabelC = new Label("Level:");
        levelLabelC.setStyle("-fx-text-fill: white;");
        TextField levelFieldC = new TextField();
        levelFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        levelFieldC.setPrefWidth(20);
        VBox levelBoxC = new VBox(10, levelLabelC, levelFieldC);

        Button randomizeButtonC = new Button("Randomize");

        Label ancestryLabelC = new Label("Ancestry:");
        ancestryLabelC.setStyle("-fx-text-fill: white;");
        TextField ancestryFieldC = new TextField();
        ancestryFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        ancestryFieldC.setPrefWidth(100);
        VBox ancestryBoxC = new VBox(10, ancestryLabelC, ancestryFieldC);

        Label backgroundLabelC = new Label("Background:");
        backgroundLabelC.setStyle("-fx-text-fill: white;");
        TextField backgroundFieldC = new TextField();
        backgroundFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        backgroundFieldC.setPrefWidth(100);
        VBox backgroundBoxC = new VBox(10, backgroundLabelC, backgroundFieldC);

        Label classLabelC = new Label("Class:");
        classLabelC.setStyle("-fx-text-fill: white;");
        TextField classFieldC = new TextField();
        classFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        classFieldC.setPrefWidth(100);
        VBox classBoxC = new VBox(10, classLabelC, classFieldC);

        Label strLabelC = new Label("STR:");
        strLabelC.setStyle("-fx-text-fill: white;");
        TextField strFieldC = new TextField();
        strFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        strFieldC.setPrefWidth(20);
        VBox strBoxC = new VBox(10, strLabelC, strFieldC);

        Label dexLabelC = new Label("DEX:");
        dexLabelC.setStyle("-fx-text-fill: white;");
        TextField dexFieldC = new TextField();
        dexFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        dexFieldC.setPrefWidth(20);
        VBox dexBoxC = new VBox(10, dexLabelC, dexFieldC);

        Label conLabelC = new Label("CON:");
        conLabelC.setStyle("-fx-text-fill: white;");
        TextField conFieldC = new TextField();
        conFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        conFieldC.setPrefWidth(20);
        VBox conBoxC = new VBox(10, conLabelC, conFieldC);

        Label intLabelC = new Label("INT:");
        intLabelC.setStyle("-fx-text-fill: white;");
        TextField intFieldC = new TextField();
        intFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        intFieldC.setPrefWidth(20);
        VBox intBoxC = new VBox(10, intLabelC, intFieldC);

        Label wisLabelC = new Label("WIS:");
        wisLabelC.setStyle("-fx-text-fill: white;");
        TextField wisFieldC = new TextField();
        wisFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        wisFieldC.setPrefWidth(20);
        VBox wisBoxC = new VBox(10, wisLabelC, wisFieldC);

        Label chaLabelC = new Label("CHA:");
        chaLabelC.setStyle("-fx-text-fill: white;");
        TextField chaFieldC = new TextField();
        chaFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        chaFieldC.setPrefWidth(20);
        VBox chaBoxC = new VBox(10, chaLabelC, chaFieldC);

        Label alignmentLabelC = new Label("Alignment:");
        alignmentLabelC.setStyle("-fx-text-fill: white;");
        TextField alignmentFieldC = new TextField();
        alignmentFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        alignmentFieldC.setPrefWidth(100);
        VBox alignmentBoxC = new VBox(10, alignmentLabelC, alignmentFieldC);

        Label acLabelC = new Label("AC:");
        acLabelC.setStyle("-fx-text-fill: white;");
        TextField acFieldC = new TextField();
        acFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        acFieldC.setPrefWidth(20);
        VBox acBoxC = new VBox(10, acLabelC, acFieldC);

        Label hpLabelC = new Label("HP:");
        hpLabelC.setStyle("-fx-text-fill: white;");
        TextField hpFieldC = new TextField();
        hpFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        hpFieldC.setPrefWidth(20);
        VBox hpBoxC = new VBox(10, hpLabelC, hpFieldC);

        Label speedLabelC = new Label("Speed:");
        speedLabelC.setStyle("-fx-text-fill: white;");
        TextField speedFieldC = new TextField();
        speedFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        speedFieldC.setPrefWidth(20);
        VBox speedBoxC = new VBox(10, speedLabelC, speedFieldC);

        Label perceptionLabelC = new Label("Perception:");
        perceptionLabelC.setStyle("-fx-text-fill: white;");
        TextField perceptionFieldC = new TextField();
        perceptionFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        perceptionFieldC.setPrefWidth(20);
        VBox perceptionBoxC = new VBox(10, perceptionLabelC, perceptionFieldC);

        Label attackLabelC = new Label("Attack:");
        attackLabelC.setStyle("-fx-text-fill: white;");
        TextField attackFieldC = new TextField();
        attackFieldC.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        attackFieldC.setPrefWidth(20);
        VBox attackBoxC = new VBox(10, attackLabelC, attackFieldC);

        Label bioLabelC = new Label("Bio:");
        bioLabelC.setStyle("-fx-text-fill: white;");
        TextArea bioAreaC = new TextArea();
        bioAreaC.setStyle("-fx-control-inner-background: black; -fx-text-fill: white;");
        bioAreaC.setPrefWidth(900);
        bioAreaC.setPrefHeight(500);
        VBox bioBoxC = new VBox(10, bioLabelC, bioAreaC);

        Image uploadImageC = new Image("file:src/main/images/UPicButton.png");
        ImageView uploadPictureButtonC = new ImageView(uploadImageC);
        uploadPictureButtonC.setFitWidth(150);
        uploadPictureButtonC.setFitHeight(150);
        uploadPictureButtonC.setPreserveRatio(true);
        uploadPictureButtonC.setStyle("-fx-cursor: hand;");

        uploadPictureButtonC.setOnMouseClicked(event -> {
            FileChooser fileChooserC = new FileChooser();
            fileChooserC.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"));
            File selectedFileC = fileChooserC.showOpenDialog(primaryStage);
            if (selectedFileC != null) {
                try {
                    Image selectedImageC = new Image(new FileInputStream(selectedFileC));
                    double currentWidthC = uploadPictureButtonC.getFitWidth();
                    double currentHeightC = uploadPictureButtonC.getFitHeight();
                    uploadPictureButtonC.setFitWidth(currentWidthC * 2);
                    uploadPictureButtonC.setFitHeight(currentHeightC * 2);
                    uploadPictureButtonC.setImage(selectedImageC);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        gridPaneC.add(nameBoxC, 0, 0);
        gridPaneC.add(levelBoxC, 1, 0);
        gridPaneC.add(randomizeButtonC, 5, 0);

        gridPaneC.add(ancestryBoxC, 0, 1);
        gridPaneC.add(backgroundBoxC, 2, 1);
        gridPaneC.add(classBoxC, 4, 1);

        gridPaneC.add(strBoxC, 0, 2);
        gridPaneC.add(dexBoxC, 1, 2);
        gridPaneC.add(conBoxC, 2, 2);
        gridPaneC.add(intBoxC, 3, 2);
        gridPaneC.add(wisBoxC, 4, 2);
        gridPaneC.add(chaBoxC, 5, 2);

        gridPaneC.add(alignmentBoxC, 0, 3);
        gridPaneC.add(acBoxC, 1, 3);
        gridPaneC.add(hpBoxC, 2, 3);

        gridPaneC.add(perceptionBoxC, 0, 4);
        gridPaneC.add(speedBoxC, 1, 4);
        gridPaneC.add(attackBoxC, 2, 4);

        gridPaneC.add(bioBoxC, 0, 5, 3, 1);
        gridPaneC.add(uploadPictureButtonC, 4, 5, 3, 1);

        VBox vboxC = new VBox(menuBarC, titleLabelC, gridPaneC);
        vboxC.setAlignment(Pos.TOP_CENTER);

        Scene sceneC = new Scene(vboxC, 1800, 1000);

        Image backgroundImageC = new Image("file:src/main/images/quizCBackground.png");
        BackgroundImage backgroundC = new BackgroundImage(
                backgroundImageC,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.DEFAULT.getWidth(),
                        BackgroundSize.DEFAULT.getHeight(),
                        false, false, false, false)
        );
        vboxC.setBackground(new Background(backgroundC));

        bioAreaC.prefWidthProperty().bind(sceneC.widthProperty().divide(4));
        bioAreaC.prefHeightProperty().bind(sceneC.heightProperty().divide(4));
        uploadPictureButtonC.fitWidthProperty().bind(sceneC.widthProperty().divide(4));
        uploadPictureButtonC.fitHeightProperty().bind(sceneC.heightProperty().divide(4));

        return sceneC;
    }
}


