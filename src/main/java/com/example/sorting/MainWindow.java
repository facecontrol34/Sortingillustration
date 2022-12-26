package com.example.sorting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MainWindow {
    public static Float[] array; // массивы
    public static Float[] array2;
    public static Float[] array3;
    public static CreateArray createArray;
    private InsertionSort insertionSort; // объекты классов сортировки
    private BubbleSort bubbleSort;
    private String arrays;
    public static String firstArrayVisual;
    public static String secondArrayVisual;
    public static String mergeArrayVisual;
    public static String visualArray;
    public static String firstTextArray;

    @FXML
    private TextField FirstArray;

    @FXML
    private Button buttonMerge;

    @FXML
    private Button buttonSort;

    @FXML
    private ImageView firstImage;

    @FXML
    private ImageView secondImage;

    @FXML
    private ImageView mergeImage;

    @FXML
    private CheckBox firstMethod;

    @FXML
    private TextField resultArray;

    @FXML
    private TextField SecondArray;

    @FXML
    private Button buttonVisual;

    @FXML
    private CheckBox secondMethod;
    private javax.swing.JOptionPane JOptionPane;
    private VisualArray VisualArray;
    public static boolean orientationFirst;
    public static boolean orientationSecond;

    @FXML
    void OnButtonMerge(ActionEvent event) { // Кнопка "Слияние массивов"
        arrays = FirstArray.getText() + ", " + SecondArray.getText();
        try{
            mergeArrayVisual = arrays;
            createArray = new CreateArray(arrays);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Один из ваших массивов незакончен или некорекктен!\nУдалите запятую или букву и введите числовое значение.");
        }

        this.array3 = createArray.getArray();

        if(!firstMethod.isSelected() && !secondMethod.isSelected())JOptionPane.showMessageDialog(null, "Выберите метод сортировки!");

        if(firstMethod.isSelected() && secondMethod.isSelected()){
            JOptionPane.showMessageDialog(null, "Выберите только один метод сортировки!");
        }

        else if(firstMethod.isSelected()){
            insertionSort = new InsertionSort(this.array3);
            resultArray.setText(insertionSort.getArray());
        }
        else if(secondMethod.isSelected()){
            bubbleSort = new BubbleSort(this.array3);
            resultArray.setText(bubbleSort.getArray());
        }
    }

    @FXML
    void OnButtonSort(ActionEvent event) { // кнопка "Сортировать"

        try{
            firstArrayVisual = FirstArray.getText();
            createArray = new CreateArray(FirstArray.getText());
            this.array = createArray.getArray();

            secondArrayVisual = SecondArray.getText();
            createArray = new CreateArray(SecondArray.getText());
            this.array2 = createArray.getArray();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Один из ваших массивов незакончен или некорекктен!\nУдалите запятую или букву и введите числовое значение.");
        }



        if(!firstMethod.isSelected() && !secondMethod.isSelected())JOptionPane.showMessageDialog(null, "Выберите метод сортировки!");

        if(firstMethod.isSelected() && secondMethod.isSelected()){
            JOptionPane.showMessageDialog(null, "Выберите только один метод сортировки!");
        }

        else if(firstMethod.isSelected()){
            insertionSort = new InsertionSort(this.array);
            FirstArray.setText(insertionSort.getArray());

            insertionSort = new InsertionSort(this.array2);
            SecondArray.setText(insertionSort.getArray());
        }
        else if(secondMethod.isSelected()){

            bubbleSort = new BubbleSort(this.array);
            FirstArray.setText(bubbleSort.getArray());

            bubbleSort = new BubbleSort(this.array2);
            SecondArray.setText(bubbleSort.getArray());
        }
    }

    @FXML
    void onFirstVisual(MouseEvent event) { // окно иллюстрации сортировки 1
        try {
            Sort.stringArray = "";
            firstTextArray = firstArrayVisual;
            orientationFirst = firstMethod.isSelected();
            orientationSecond = secondMethod.isSelected();
            visualArray = FirstArray.getText();
//            VisualArray.setArray(array);
            com.example.sorting.VisualArray.arrayFirst = array;
//            VisualArray = new VisualArray(firstArrayVisual, FirstArray.getText());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("visual-array.fxml"));
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

    @FXML
    void onMergeVisual(MouseEvent event) { // окно иллюстрации слияния
        try {
            Sort.stringArray = "";
            firstTextArray = mergeArrayVisual;
            orientationFirst = firstMethod.isSelected();
            orientationSecond = secondMethod.isSelected();
            visualArray = resultArray.getText();
            com.example.sorting.VisualArray.arrayFirst = array3;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("visual-array.fxml"));
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

    @FXML
    void onSecondVisual(MouseEvent event) { // окно иллюстрации сортировки 2
        try {
            Sort.stringArray = "";
            firstTextArray = secondArrayVisual;
            orientationFirst = firstMethod.isSelected();
            orientationSecond = secondMethod.isSelected();
            visualArray = SecondArray.getText();
            com.example.sorting.VisualArray.arrayFirst = array2;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("visual-array.fxml"));
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



    @FXML
    void OnFirstMethod(ActionEvent event) {

    }

    @FXML
    void OnSecondMethod(ActionEvent event) {

    }
}