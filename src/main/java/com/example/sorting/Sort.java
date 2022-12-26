package com.example.sorting;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;

public class Sort { // сортировка
    static VisualArray visualArray;
    private Float[] array;
    public static String stringArray = "";
    public String lastStringArray = "";
    public Sort(){
        stringArray = "";
    }
    public void BubbleSortVisual(Float[] array) { // вывод итераций в методе пузырька
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Timeline> timelines = new ArrayList<>();
        boolean sorted = false;
        float temp;
        while (!sorted) {
            sorted = true;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
                for (int j = 0; j < array.length; j++) {
                    stringArray += String.valueOf(array[j]);
                    if(j != array.length - 1)stringArray += ", ";
                    if(lastStringArray != stringArray)list.add(stringArray);
                    lastStringArray = stringArray;
                }

                stringArray = "";

            }
        }

            for (int i = 0;i< list.size();i++) {
                timelines.add(new Timeline(new KeyFrame(Duration.millis((1+i)*300), actionEvent -> {
                    visualArray.secondArray.setText(list.get(0));
                    list.remove(0);
                })));
                timelines.get(i).playFromStart(); // задержка вывода
            }



    }

    public void InsertionSortVisual(Float[] array){ // вывод итераций в методе простой вставки
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Timeline> timelines = new ArrayList<>();
        for (int left = 0; left < array.length; left++) {

            float value = array[left];

            int i = left - 1;
            for (; i >= 0; i--) {


                if ((value < array[i])) {
                    array[i + 1] = array[i];
                }



               if(!(value < array[i])){
                    break;
                }

            }

            array[i + 1] = value;
            for (int j = 0; j < array.length; j++) {
                stringArray += String.valueOf(array[j]);
                if(j != array.length - 1)stringArray += ", ";

                list.add(stringArray);
                lastStringArray = stringArray;

            }
            stringArray = "";


        }
        for (int i = 0;i< list.size();i++) {
            timelines.add(new Timeline(new KeyFrame(Duration.seconds((1+i)), actionEvent -> {
                visualArray.secondArray.setText(list.get(0));
                list.remove(0);
            })));
            timelines.get(i).playFromStart(); // задержка вывода
        }

    }

    public static void setVisualArray(VisualArray visualArray) {
        Sort.visualArray = visualArray;
    }
}
