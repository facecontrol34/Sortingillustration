package com.example.sorting;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;

public class VisualArray { // окно с промежуточным массивом и ответом
    public static Float[] arrayFirst;
    private String first;
    private String second;
    private BubbleSort bubbleSort;
    private Sort sort;
    public static boolean isSorted = true;

    @FXML
    private Text firstArray;

    @FXML
    private Button start;

    @FXML
    private Label middleArray;

    @FXML
    private Label resultArray;

    @FXML
    public Text secondArray;

    @FXML
    private Label sourceArray;

    @FXML
    private Text thirdArray;

    @FXML
    void onStart(ActionEvent event)throws InterruptedException  { // работа при нажитии "Начать"
        Sort.setVisualArray(this);
        firstArray.setText(MainWindow.firstTextArray);
        thirdArray.setText(MainWindow.visualArray);
        sort = new Sort();
        isSorted = true;
        MainWindow.createArray = new CreateArray(firstArray.getText());
        Sort.stringArray = "";
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1
            ), time-> { // задержка вывода промежуточного массива
                if(MainWindow.orientationFirst){ //если выбрали 1 метод
                    sort.InsertionSortVisual(MainWindow.createArray.getArray());
                }
                if(MainWindow.orientationSecond){ // если выбран 2 метод
                    sort.BubbleSortVisual(MainWindow.createArray.getArray());
                }


                    }));
            timeline.playFromStart();
//        }
    }
}
