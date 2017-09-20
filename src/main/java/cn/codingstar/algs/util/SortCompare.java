package cn.codingstar.algs.util;

import cn.codingstar.algs.sort.Insertion;
import cn.codingstar.algs.sort.InsertionOptimization;
import cn.codingstar.algs.sort.Selection;
import cn.codingstar.algs.sort.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

    public static double time(String alg, Comparable[] arr) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Selection"))
            Selection.sort(arr);
        if (alg.equals("Insertion"))
            Insertion.sort(arr);
        if (alg.equals("InsertionOptimization"))
            InsertionOptimization.sort(arr);
        if (alg.equals("Shell"))
            Shell.sort(arr);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // 使用算法alg将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // 进行一次测试，生成一个数组并排序
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Selection";
        String alg2 = "Insertion";
        String alg3 = "InsertionOptimization";
        int N = 1000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        double t3 = timeRandomInput(alg3, N, T);
        StdOut.printf("For %d random Doubles %s is %.1f time faster than %s \n",N,alg2,t1/t2,alg1);
        StdOut.printf("For %d random Doubles %s is %.1f time faster than %s \n",N,alg3,t1/t3,alg1);
    }

}
