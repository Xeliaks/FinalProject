package com.example.finalproject.scenes;

import com.example.finalproject.Entities.*;
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

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class QuizM {

    private Stage primaryStage;
    private MonsterLinkedList monsterLinkedList = new MonsterLinkedList();
    private Monster monster = new Monster();

    public QuizM(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initializeMonsterList();
    }

    private void initializeMonsterList() {
        String folderPath = "src/main/monsters";
        monsterLinkedList.loadFromFolder(folderPath);
    }

    public Scene createScene() {
        AppMenuBar appMenuBarM = new AppMenuBar(primaryStage);
        MenuBar menuBarM = appMenuBarM.createMenuBar();

        Label titleLabelM = new Label("Monster");
        titleLabelM.setFont(Font.font("Book Antiqua", 24));
        titleLabelM.setAlignment(Pos.TOP_CENTER);
        titleLabelM.setStyle("-fx-text-fill: white;");

        GridPane gridPaneM = new GridPane();
        gridPaneM.setHgap(10);
        gridPaneM.setVgap(10);
        gridPaneM.setPadding(new Insets(10));

        for (int i = 0; i < 6; i++) {
            ColumnConstraints columnM = new ColumnConstraints();
            columnM.setPercentWidth(100.0 / 6);
            gridPaneM.getColumnConstraints().add(columnM);
        }

        for (int i = 0; i < 5; i++) {
            RowConstraints rowM = new RowConstraints();
            rowM.setPercentHeight(100.0 / 7);
            gridPaneM.getRowConstraints().add(rowM);
        }
        RowConstraints lastRowM = new RowConstraints();
        lastRowM.setPercentHeight(200.0 / 7);
        gridPaneM.getRowConstraints().add(lastRowM);

        Label nameLabelM = new Label("Name:");
        nameLabelM.setStyle("-fx-text-fill: white;");
        TextField nameFieldM = new TextField();
        nameFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        nameFieldM.setPrefWidth(100);
        VBox nameBoxM = new VBox(10, nameLabelM, nameFieldM);

        Label levelLabelM = new Label("Level:");
        levelLabelM.setStyle("-fx-text-fill: white;");
        TextField levelFieldM = new TextField();
        levelFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        levelFieldM.setPrefWidth(20);
        VBox levelBoxM = new VBox(10, levelLabelM, levelFieldM);

        Button randomizeButtonM = new Button("Randomize");

        Button importButtonM = new Button("Import");

        Button exportButtonM = new Button("Export");

        Label strLabelM = new Label("STR:");
        strLabelM.setStyle("-fx-text-fill: white;");
        TextField strFieldM = new TextField();
        strFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        strFieldM.setPrefWidth(20);
        VBox strBoxM = new VBox(10, strLabelM, strFieldM);

        Label dexLabelM = new Label("DEX:");
        dexLabelM.setStyle("-fx-text-fill: white;");
        TextField dexFieldM = new TextField();
        dexFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        dexFieldM.setPrefWidth(20);
        VBox dexBoxM = new VBox(10, dexLabelM, dexFieldM);

        Label conLabelM = new Label("CON:");
        conLabelM.setStyle("-fx-text-fill: white;");
        TextField conFieldM = new TextField();
        conFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        conFieldM.setPrefWidth(20);
        VBox conBoxM = new VBox(10, conLabelM, conFieldM);

        Label intLabelM = new Label("INT:");
        intLabelM.setStyle("-fx-text-fill: white;");
        TextField intFieldM = new TextField();
        intFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        intFieldM.setPrefWidth(20);
        VBox intBoxM = new VBox(10, intLabelM, intFieldM);

        Label wisLabelM = new Label("WIS:");
        wisLabelM.setStyle("-fx-text-fill: white;");
        TextField wisFieldM = new TextField();
        wisFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        wisFieldM.setPrefWidth(20);
        VBox wisBoxM = new VBox(10, wisLabelM, wisFieldM);

        Label chaLabelM = new Label("CHA:");
        chaLabelM.setStyle("-fx-text-fill: white;");
        TextField chaFieldM = new TextField();
        chaFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        chaFieldM.setPrefWidth(20);
        VBox chaBoxM = new VBox(10, chaLabelM, chaFieldM);

        Label alignmentLabelM = new Label("Alignment:");
        alignmentLabelM.setStyle("-fx-text-fill: white;");
        TextField alignmentFieldM = new TextField();
        alignmentFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        alignmentFieldM.setPrefWidth(100);
        VBox alignmentBoxM = new VBox(10, alignmentLabelM, alignmentFieldM);

        Label acLabelM = new Label("AC:");
        acLabelM.setStyle("-fx-text-fill: white;");
        TextField acFieldM = new TextField();
        acFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        acFieldM.setPrefWidth(20);
        VBox acBoxM = new VBox(10, acLabelM, acFieldM);

        Label hpLabelM = new Label("HP:");
        hpLabelM.setStyle("-fx-text-fill: white;");
        TextField hpFieldM = new TextField();
        hpFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        hpFieldM.setPrefWidth(20);
        VBox hpBoxM = new VBox(10, hpLabelM, hpFieldM);

        Label speedLabelM = new Label("Speed:");
        speedLabelM.setStyle("-fx-text-fill: white;");
        TextField speedFieldM = new TextField();
        speedFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        speedFieldM.setPrefWidth(20);
        VBox speedBoxM = new VBox(10, speedLabelM, speedFieldM);

        Label perceptionLabelM = new Label("Perception:");
        perceptionLabelM.setStyle("-fx-text-fill: white;");
        TextField perceptionFieldM = new TextField();
        perceptionFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        perceptionFieldM.setPrefWidth(20);
        VBox perceptionBoxM = new VBox(10, perceptionLabelM, perceptionFieldM);

        Label attackLabelM = new Label("Attack:");
        attackLabelM.setStyle("-fx-text-fill: white;");
        TextField attackFieldM = new TextField();
        attackFieldM.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        attackFieldM.setPrefWidth(20);
        VBox attackBoxM = new VBox(10, attackLabelM, attackFieldM);

        Label bioLabelM = new Label("Bio:");
        bioLabelM.setStyle("-fx-text-fill: white;");
        TextArea bioAreaM = new TextArea();
        bioAreaM.setStyle("-fx-control-inner-background: black; -fx-text-fill: white;");
        bioAreaM.setPrefWidth(900);
        bioAreaM.setPrefHeight(500);
        VBox bioBoxM = new VBox(10, bioLabelM, bioAreaM);

        Image uploadImageM = new Image("file:src/main/images/UPicButton.png");
        ImageView uploadPictureButtonM = new ImageView(uploadImageM);
        uploadPictureButtonM.setFitWidth(200);
        uploadPictureButtonM.setFitHeight(200);
        uploadPictureButtonM.setPreserveRatio(true);
        uploadPictureButtonM.setStyle("-fx-cursor: hand;");

        uploadPictureButtonM.setOnMouseClicked(event -> {
            FileChooser fileChooserC = new FileChooser();
            fileChooserC.setTitle("Open Image File");
            fileChooserC.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"));
            File characterFolderC = new File("src/main/images/monsters");
            if (characterFolderC.exists() && characterFolderC.isDirectory()) {
                fileChooserC.setInitialDirectory(characterFolderC);
            }
            File selectedFileC = fileChooserC.showOpenDialog(primaryStage);
            if (selectedFileC != null) {
                try {
                    Image selectedImageC = new Image(new FileInputStream(selectedFileC));
                    uploadPictureButtonM.setImage(selectedImageC);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        importButtonM.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Import Monster File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
            File monsterFolder = new File("src/main/monsters");
            if (monsterFolder.exists() && monsterFolder.isDirectory()) {
                fileChooser.setInitialDirectory(monsterFolder);
            }
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                try {
                    List<String> lines = Files.readAllLines(selectedFile.toPath());
                    MonsterParser parser = new MonsterParser();
                    Monster importedMonster = parser.parseMonster(lines);
                    nameFieldM.setText(importedMonster.getNameM());
                    levelFieldM.setText(String.valueOf(importedMonster.getLevelM()));
                    strFieldM.setText(String.valueOf(importedMonster.getStrengthM()));
                    dexFieldM.setText(String.valueOf(importedMonster.getDexterityM()));
                    conFieldM.setText(String.valueOf(importedMonster.getConstitutionM()));
                    intFieldM.setText(String.valueOf(importedMonster.getIntelligenceM()));
                    wisFieldM.setText(String.valueOf(importedMonster.getWisdomM()));
                    chaFieldM.setText(String.valueOf(importedMonster.getCharismaM()));
                    alignmentFieldM.setText(importedMonster.getAlignmentM());
                    acFieldM.setText(String.valueOf(importedMonster.getArmorClassM()));
                    hpFieldM.setText(String.valueOf(importedMonster.getHitPointsM()));
                    speedFieldM.setText(String.valueOf(importedMonster.getSpeedM()));
                    perceptionFieldM.setText(String.valueOf(importedMonster.getPerceptionM()));
                    attackFieldM.setText(importedMonster.getAttackM());
                    bioAreaM.setText(importedMonster.getBioM());
                    uploadPictureButtonM.setImage(new Image("file:" + importedMonster.getImageLinkM()));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error: The file format is incorrect.");
                }
            }
        });

        exportButtonM.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Export Monster File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
            File monsterFolder = new File("src/main/monsters");
            if (monsterFolder.exists() && monsterFolder.isDirectory()) {
                fileChooser.setInitialDirectory(monsterFolder);
            }
            File selectedFile = fileChooser.showSaveDialog(primaryStage);
            if (selectedFile != null) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(selectedFile))) {
                    writer.println("name: " + nameFieldM.getText());
                    writer.println("level: " + levelFieldM.getText());
                    writer.println("strength: " + strFieldM.getText());
                    writer.println("dexterity: " + dexFieldM.getText());
                    writer.println("constitution: " + conFieldM.getText());
                    writer.println("intelligence: " + intFieldM.getText());
                    writer.println("wisdom: " + wisFieldM.getText());
                    writer.println("charisma: " + chaFieldM.getText());
                    writer.println("alignment: " + alignmentFieldM.getText());
                    writer.println("armorClass: " + acFieldM.getText());
                    writer.println("hitPoints: " + hpFieldM.getText());
                    writer.println("perception: " + perceptionFieldM.getText());
                    writer.println("speed: " + speedFieldM.getText());
                    writer.println("attack: " + attackFieldM.getText());
                    writer.println("bio: " + bioAreaM.getText());

                    Image image = uploadPictureButtonM.getImage();
                    String imagePath = "";
                    if (image != null) {
                        imagePath = image.getUrl().replace("file:", "");
                    }
                    writer.println("imageLink: " + imagePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        gridPaneM.add(nameBoxM, 0, 0);
        gridPaneM.add(levelBoxM, 1, 0);
        gridPaneM.add(importButtonM, 3, 0);
        gridPaneM.add(exportButtonM, 4, 0);
        gridPaneM.add(randomizeButtonM, 5, 0);

        gridPaneM.add(strBoxM, 0, 2);
        gridPaneM.add(dexBoxM, 1, 2);
        gridPaneM.add(conBoxM, 2, 2);
        gridPaneM.add(intBoxM, 3, 2);
        gridPaneM.add(wisBoxM, 4, 2);
        gridPaneM.add(chaBoxM, 5, 2);

        gridPaneM.add(alignmentBoxM, 0, 3);
        gridPaneM.add(acBoxM, 1, 3);
        gridPaneM.add(hpBoxM, 2, 3);

        gridPaneM.add(perceptionBoxM, 0, 4);
        gridPaneM.add(speedBoxM, 1, 4);
        gridPaneM.add(attackBoxM, 2, 4);

        gridPaneM.add(bioBoxM, 0, 5, 3, 1);
        gridPaneM.add(uploadPictureButtonM, 4, 5, 3, 1);

        VBox vboxM = new VBox(menuBarM, titleLabelM, gridPaneM);
        vboxM.setAlignment(Pos.TOP_CENTER);

        Scene sceneM = new Scene(vboxM, 1800, 1000);

        Image backgroundImageM = new Image("file:src/main/images/quizMBackground.png");
        BackgroundImage backgroundM = new BackgroundImage(
                backgroundImageM,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.DEFAULT.getWidth(),
                        BackgroundSize.DEFAULT.getHeight(),
                        false, false, false, false)
        );
        vboxM.setBackground(new Background(backgroundM));

        return sceneM;
    }
}
