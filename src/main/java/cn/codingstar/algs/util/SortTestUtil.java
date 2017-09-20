package cn.codingstar.algs.util;

import java.util.Random;

public class SortTestUtil {

    private static Random random = new Random();

    public static Comparable[] generateRandomIntegers(Integer num){
        Comparable[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = random.nextInt(num);
        }
        return arr;
    }
}
