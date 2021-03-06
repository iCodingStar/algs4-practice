package cn.codingstar.algs.sort;

import cn.codingstar.algs.util.SortTestUtil;
import edu.princeton.cs.algs4.StdOut;

/**
 * 选择排序
 */
public class Selection {

    public static void sort(Comparable[] arr){
        if (arr == null){
            return;
        }
        // 遍历[o,arr.length)区间的数据
        for (int i = 0; i < arr.length; i++) {
            Integer minIndex = i;
            // 选择[i,arr.length)之间最小的数据，并记录其索引值
            for (int j = i; j < arr.length; j++) {
                if (less(arr[j], arr[minIndex]))
                    minIndex = j;
            }
            // 将arr[i]与arr[minIndex]的值交换
            exch(arr,i,minIndex);
        }
    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] arr,int i,int j){
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

    public static void main(String[] args) {
        Comparable[] arr = SortTestUtil.generateRandomIntegers(10000);
        sort(arr);
        show(arr);
        StdOut.println(isSorted(arr));
    }
}
