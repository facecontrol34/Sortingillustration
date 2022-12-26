package com.example.sorting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EnterMenu { // первое окно с кнопкой начать и текстом
    @FXML
    private Button Enter_button;

    @FXML
    void OnEnter(ActionEvent event) { // при нажатии на кнопку запуск 2 окна и скрытие первого
            Enter_button.getScene().getWindow().hide();

            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("main-menu.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Sorting");
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }
