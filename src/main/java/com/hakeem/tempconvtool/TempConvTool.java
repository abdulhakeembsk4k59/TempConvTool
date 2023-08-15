package com.hakeem.tempconvtool;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class TempConvTool extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TempConvTool.class.getResource("hello-view.fxml"));
        VBox rootNode = fxmlLoader.load();

        MenuBar menuBar = createMenu();

        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode);
        stage.setTitle("Temp Converter");
        stage.setScene(scene);
        stage.show();
    }

    private MenuBar createMenu(){
//        File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(actionEvent -> System.out.println("New MenuItem Clicked!"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(ActionEvent -> {
            Platform.exit();
            System.exit(0);
        });
//        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                Platform.exit();
//                System.exit(0);
//            }
//        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

//        Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(actionEvent -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);

//        Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first Java Desktop Application");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginner but soon i will be pro! and start developing awesome java games");
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("Yes Button was clicked");
        }else{
            System.out.println("No Button was clicked");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}