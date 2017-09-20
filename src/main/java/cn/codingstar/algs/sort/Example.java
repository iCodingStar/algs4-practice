package cn.codingstar.algs.sort;

import edu.princeton.cs.algs4.StdOut;

public class Example {

    public static void sort(Comparable[] arr){

    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void each(Comparable[] arr,int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void show(Comparable[] arr){
        // 在单行中打印数组
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] arr){
        // 测试数组元素是否有序
        for (int i = 0; i < arr.length - 1; i++) {
            if (less(arr[i+1],arr[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("Hello World");
    }
}
