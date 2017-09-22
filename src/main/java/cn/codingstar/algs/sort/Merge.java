package cn.codingstar.algs.sort;

import cn.codingstar.algs.util.SortTestUtil;
import edu.princeton.cs.algs4.StdOut;

/**
 * 归并排序
 */
public class Merge {

    private static Comparable[] aux;// 归并需要的辅助数组


    public static void sort(Comparable[] arr) {
        if (arr == null) {
            return;
        }
        aux = new Comparable[arr.length];//一次性分配空间
        sort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        // 将arr[lo,hi]复制到aux[lo,hi]中
        for (int k = 0; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (less(aux[j], aux[i])) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
