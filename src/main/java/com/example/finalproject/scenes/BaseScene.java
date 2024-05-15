package com.example.finalproject.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.example.finalproject.scenes.*;

import java.io.*;

public class BaseScene {

    private Stage primaryStage;

    public BaseScene(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene createScene() {
        AppMenuBar appMenuBar = new AppMenuBar(primaryStage);
        MenuBar menuBar = appMenuBar.createMenuBar();
        appMenuBar.setOpenMenuItemDisabled(true);
        appMenuBar.setSaveMenuItemDisabled(true);
        appMenuBar.setEditMenuDisabled(true);
        appMenuBar.setReturnToMainMenuItemDisabled(true);

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
            QuizC quizC = new QuizC(primaryStage);
            Scene quizCScene = quizC.createScene();
            primaryStage.setScene(quizCScene);
        });

        monsterImageView.setOnMouseClicked(event -> {
            QuizM quizM = new QuizM(primaryStage);
            Scene quizMScene = quizM.createScene();
            primaryStage.setScene(quizMScene);
        });

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        GridPane buttonsPane = new GridPane();
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setHgap(50);
        buttonsPane.add(characterLabel, 0, 0);
        buttonsPane.add(characterImageView, 0, 1);
        buttonsPane.add(monsterLabel, 1, 0);
        buttonsPane.add(monsterImageView, 1, 1);
        buttonsPane.setPadding(new Insets(20));

        BorderPane root = new BorderPane();

        Image backgroundImage = new Image("file:src/main/images/background.png");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.DEFAULT.getWidth(),
                        BackgroundSize.DEFAULT.getHeight(),
                        false, false, false, false)
        );

        Background backgroundForPane = new Background(background);
        root.setBackground(backgroundForPane);
        root.setTop(menuBar);
        root.setCenter(buttonsPane);

        return new Scene(root, 1800, 1000);
    }
}

