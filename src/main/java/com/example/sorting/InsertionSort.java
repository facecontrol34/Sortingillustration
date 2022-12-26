package com.example.sorting;

public class InsertionSort { // алгоритм сортировки простой вставкой
    private String stringArray = "";
    public  InsertionSort(Float[] array){
        for (int left = 0; left < array.length; left++) {

            float value = array[left];

            int i = left - 1;
            for (; i >= 0; i--) {

                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {

                    break;
                }
            }

            array[i + 1] = value;
        }
        for(int i = 0; i < array.length; i++){
            stringArray += String.valueOf(array[i]);
            if(i == array.length - 1)break;
            stringArray += ", ";

        }

    }

    public String getArray(){
        return this.stringArray;
    }
}
