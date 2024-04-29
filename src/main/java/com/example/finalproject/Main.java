package com.example.finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(openMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);

        Menu editMenu = new Menu("Edit");
        MenuItem copyMenuItem = new MenuItem("Copy");
        MenuItem pasteMenuItem = new MenuItem("Paste");
        editMenu.getItems().addAll(copyMenuItem, pasteMenuItem);

        Menu viewMenu = new Menu("View");
        MenuItem browseCharacterMenuItem = new MenuItem("Browse Character Collection");
        MenuItem browseMonsterMenuItem = new MenuItem("Browse Monster Collection");
        viewMenu.getItems().addAll(browseCharacterMenuItem, browseMonsterMenuItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu);

        ImageView characterImageView = new ImageView(new Image("https://i.imgur.com/qiqabeQ.jpg"));
        characterImageView.setFitWidth(600);
        characterImageView.setFitHeight(800);
        Label characterLabel = new Label("Create Character");
        characterLabel.setStyle("-fx-font-size: 18; -fx-font-family: 'Book Antiqua'; -fx-text-fill: white;");
        characterLabel.setAlignment(Pos.CENTER);

        ImageView monsterImageView = new ImageView(new Image("https://sustainaspell.files.wordpress.com/2022/08/troll_frosttroll.png?w=870"));
        monsterImageView.setFitWidth(600);
        monsterImageView.setFitHeight(800);
        Label monsterLabel = new Label("Create Monster");
        monsterLabel.setStyle("-fx-font-size: 18; -fx-font-family: 'Book Antiqua'; -fx-text-fill: white;");
        monsterLabel.setAlignment(Pos.CENTER);


        characterImageView.setOnMouseClicked(event -> {
            System.out.println("Character button clicked");

        });

        monsterImageView.setOnMouseClicked(event -> {
            System.out.println("Monster button clicked");

        });


        FileChooser fileChooser = new FileChooser();


        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );


        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));


        openMenuItem.setOnAction(event -> {

            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {

                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                    String line;
                    StringBuilder content = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }

                    TextArea textArea = new TextArea(content.toString());
                    Stage newStage = new Stage();
                    newStage.setScene(new Scene(textArea, 400, 300));
                    newStage.setTitle("File Content");
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        saveMenuItem.setOnAction(event -> {

            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

                    writer.write("Sample");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });





        GridPane buttonsPane = new GridPane();
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setHgap(50);
        buttonsPane.add(characterLabel, 0, 0);
        buttonsPane.add(characterImageView, 0, 1);
        buttonsPane.add(monsterLabel, 1, 0);
        buttonsPane.add(monsterImageView, 1, 1);
        buttonsPane.setPadding(new Insets(20));


        BorderPane root = new BorderPane();

        Image backgroundImage = new Image("file:background.png");

        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );

        Background backgroundForPane = new Background(background);
        root.setBackground(backgroundForPane);
        root.setTop(menuBar);
        root.setCenter(buttonsPane);


        Scene scene = new Scene(root, 1800, 1000);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Character and Monster Creator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}