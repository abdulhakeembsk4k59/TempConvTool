package com.hakeem.tempconvtool;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TempConvController implements  Initializable{

    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField userInputField;
    @FXML
    public Button convertButton;

    private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

    private boolean isC_to_F = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);

        choiceBox.setValue(C_TO_F_TEXT);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            isC_to_F = t1.equals(C_TO_F_TEXT);
        });

        convertButton.setOnAction(actionEvent -> {
            convert();
        });

    }

    private void convert() {
        String input = userInputField.getText();
        float enteredTemprature = 0.0f;

        try {
            enteredTemprature = Float.parseFloat(input);
        }catch (Exception e){
            warnUser();
            return;
        }

        float newTemprature = 0.0f;

        if(isC_to_F){
            newTemprature = (enteredTemprature * 9/5) + 32;
        }else{
            newTemprature = (enteredTemprature - 32) * 5/9;
        }

        display(newTemprature);

    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature Entered!");
        alert.setContentText("Please enter a valid temperature..");
        alert.show();
    }

    private void display(float newTemprature) {
        String unit = isC_to_F?" F":" C";
        System.out.println("Teprature is : "+newTemprature+unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("Teprature is : "+newTemprature+unit);
        alert.show();
    }
}