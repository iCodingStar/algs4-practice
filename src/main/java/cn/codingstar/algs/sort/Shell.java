package cn.codingstar.algs.sort;

import cn.codingstar.algs.util.SortTestUtil;
import edu.princeton.cs.algs4.StdOut;

public class Shell {

    public static void sort(Comparable[] arr) {
        if (arr == null) {
            return;
        }
        int N = arr.length;
        int h = 1;
        while (h < N / 3) h = h + 1;// 递增序列
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                    exch(arr, j, j - h);
                }
            }
            h/=3;
        }

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void show(Comparable[] arr) {
        // 在单行中打印数组
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] arr) {
        // 测试数组元素是否有序
        for (int i = 0; i < arr.length - 1; i++) {
            if (less(arr[i + 1], arr[i]))
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
