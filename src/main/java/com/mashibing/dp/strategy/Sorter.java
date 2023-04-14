package com.mashibing.dp.strategy;

import java.util.HashMap;

public class Sorter<T> {
     private static HashMap<String,Comparator> map = new HashMap<>();

     static {
         map.put("W",new CatWeightComparator());
         map.put("H",new CatHeightComparator());
     }
    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }
    public void sort(T[] arr,String s){
         sort(arr,getStrategy(s));
    }

    //sort(int)

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public Comparator getStrategy(String s) {
         return map.get(s);
    }
}
