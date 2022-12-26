package com.example.sorting;

public class BubbleSort {
    private String stringArray = "";

    public BubbleSort(Float[] array) { // алгоритм сортировки пузырька
        boolean sorted = false;
        float temp;
        while (!sorted) { // сравнение двух рядом стоящих элементов и замена позиции
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }

        for(int i = 0; i < array.length; i++){ // остановка сравнения
            stringArray += String.valueOf(array[i]);
            if(i == array.length - 1)break;
            stringArray += ", ";

        }
    }


    public String getArray(){
        return this.stringArray;
    } // возвращение массива
}
