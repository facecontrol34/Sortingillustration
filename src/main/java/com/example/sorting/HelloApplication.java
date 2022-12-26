package com.example.sorting;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application { // run this class
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EnterMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600.0, 232.0);
            stage.setTitle("Sorting");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}