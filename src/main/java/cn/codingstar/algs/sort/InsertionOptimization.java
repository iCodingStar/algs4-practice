package cn.codingstar.algs.sort;

import cn.codingstar.algs.util.SortTestUtil;
import edu.princeton.cs.algs4.StdOut;

/**
 * 插入排序优化
 */
public class InsertionOptimization {

    public static void sort(Comparable[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            // 第i个元素与前面的元素依次比较，如果arr[j] < arr[j-1],交换之
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && less(e, arr[j - 1]); j--) {
                // 如果满足条件，将元素arr[j-1]后移
                arr[j] = arr[j-1];
            }
            // 找到插入位置后，将元素放入
            arr[j] = e;
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
