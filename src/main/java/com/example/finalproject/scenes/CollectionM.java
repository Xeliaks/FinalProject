package com.example.finalproject.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.example.finalproject.Entities.*;
import com.example.finalproject.scenes.*;

public class CollectionM {

    private Scene scene;
    private MonsterLinkedList monsterLinkedList = new MonsterLinkedList();

    private void initializeCharacterList() {
        String folderPath = "src/main/monsters";
        monsterLinkedList.loadFromFolder(folderPath);
        monsterLinkedList.quickSort();
    }

    public CollectionM(Stage primaryStage) {
        initializeCharacterList();
        AppMenuBar appMenuBar = new AppMenuBar(primaryStage);
        MenuBar menuBar = appMenuBar.createMenuBar();
        appMenuBar.setBrowseMonsterMenuItemDisabled(true);

        Label label = new Label("Character Collection");
        label.setFont(Font.font("Book Antiqua", 24));
        label.setTextFill(Color.WHITE);
        label.setAlignment(Pos.CENTER);

        HBox searchBox = new HBox(10);
        searchBox.setAlignment(Pos.CENTER);
        TextField searchField = new TextField();
        Button searchButton = new Button("Search");
        searchBox.getChildren().addAll(searchField, searchButton);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        int row = 0;
        int col = 0;
        for (Monster monster : monsterLinkedList.getCharacters()) {
            MonsterInfo monsterInfo = new MonsterInfo(monster, primaryStage);
            gridPane.add(monsterInfo, col, row);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        searchButton.setOnAction(e -> {
            String searchText = searchField.getText().trim();
            Monster result = monsterLinkedList.binarySearch(searchText);
            if (result != null) {
                gridPane.getChildren().clear();
                MonsterInfo monsterInfo = new MonsterInfo(result, primaryStage);
                gridPane.add(monsterInfo, 0, 0);
            } else {
                searchField.setText("Monster not found");
            }
        });

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, searchBox, gridPane);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setStyle("-fx-background-color: black;");

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        gridPane.prefWidthProperty().bind(scrollPane.widthProperty());
        gridPane.prefHeightProperty().bind(scrollPane.heightProperty());

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(scrollPane);

        this.scene = new Scene(borderPane, 1800, 1000);
    }

    public Scene getScene() {
        return this.scene;
    }
}

