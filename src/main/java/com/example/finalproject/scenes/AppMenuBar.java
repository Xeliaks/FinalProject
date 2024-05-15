package com.example.finalproject.scenes;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import com.example.finalproject.scenes.*;



public class AppMenuBar {

    private Stage primaryStage;
    private MenuItem exitMenuItem;
    private MenuItem cutMenuItem;
    private MenuItem copyMenuItem;
    private MenuItem pasteMenuItem;
    private MenuItem browseCharacterMenuItem;
    private MenuItem browseMonsterMenuItem;
    private MenuItem returnToMainMenuItem;

    public AppMenuBar(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        returnToMainMenuItem = new MenuItem("Return to Main Screen");
        exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(returnToMainMenuItem, new SeparatorMenuItem(), exitMenuItem);

        Menu editMenu = new Menu("Edit");
        cutMenuItem = new MenuItem("Cut");
        copyMenuItem = new MenuItem("Copy");
        pasteMenuItem = new MenuItem("Paste");
        editMenu.getItems().addAll(cutMenuItem, copyMenuItem, pasteMenuItem);

        Menu viewMenu = new Menu("View");
        browseCharacterMenuItem = new MenuItem("Browse Character Collection");
        browseMonsterMenuItem = new MenuItem("Browse Monster Collection");
        viewMenu.getItems().addAll(browseCharacterMenuItem, browseMonsterMenuItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));



        exitMenuItem.setOnAction(event -> {
            primaryStage.close();
        });

        returnToMainMenuItem.setOnAction(event -> {
            BaseScene baseScene = new BaseScene(primaryStage);
            primaryStage.setScene(baseScene.createScene());
        });

        cutMenuItem.setOnAction(event -> {
            TextInputControl textInputControl = getFocusedTextInputControl();
            if (textInputControl != null) {
                String selectedText = textInputControl.getSelectedText();
                if (!selectedText.isEmpty()) {
                    Clipboard clipboard = Clipboard.getSystemClipboard();
                    ClipboardContent content = new ClipboardContent();
                    content.putString(selectedText);
                    clipboard.setContent(content);
                    textInputControl.replaceSelection("");
                }
            }
        });

        copyMenuItem.setOnAction(event -> {
            TextInputControl textInputControl = getFocusedTextInputControl();
            if (textInputControl != null) {
                String selectedText = textInputControl.getSelectedText();
                if (!selectedText.isEmpty()) {
                    Clipboard clipboard = Clipboard.getSystemClipboard();
                    ClipboardContent content = new ClipboardContent();
                    content.putString(selectedText);
                    clipboard.setContent(content);
                }
            }
        });

        pasteMenuItem.setOnAction(event -> {
            TextInputControl textInputControl = getFocusedTextInputControl();
            if (textInputControl != null) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                if (clipboard.hasString()) {
                    String clipboardText = clipboard.getString();
                    textInputControl.replaceSelection(clipboardText);
                }
            }
        });

        browseCharacterMenuItem.setOnAction(event -> {
            primaryStage.setScene(new CollectionC(primaryStage).getScene());
        });

        browseMonsterMenuItem.setOnAction(event -> {
            primaryStage.setScene(new CollectionM(primaryStage).getScene());
        });

        return menuBar;
    }

    private TextInputControl getFocusedTextInputControl() {
        Scene scene = primaryStage.getScene();
        if (scene != null) {
            if (scene.getFocusOwner() instanceof TextInputControl) {
                return (TextInputControl) scene.getFocusOwner();
            }
        }
        return null;
    }


    public void setEditMenuDisabled(boolean isDisabled) {
        cutMenuItem.setDisable(isDisabled);
        copyMenuItem.setDisable(isDisabled);
        pasteMenuItem.setDisable(isDisabled);
    }

    public void setReturnToMainMenuItemDisabled(boolean isDisabled) {
        returnToMainMenuItem.setDisable(isDisabled);
    }

}
