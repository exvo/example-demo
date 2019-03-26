package com.example.demo.main;

import java.util.Arrays;

/**
 * @Date: 2019/3/25
 * @Author: wu yang
 * @Description:
 */
public class CompareTest {

    private static Integer[] arrays = {56, 32, 55, 94, 34, 34,900, 900, 56, 67, 200, 45, 2, 4, 6, 43, 900, 433};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrays));
        sort1(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    /**
     * 冒泡排序
     * @param arrays
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort1(T[] arrays) {
        boolean flag = true;
        int len = arrays.length;
        for (int i = 1; i < len && flag; i++) {
            flag = false;
            for (int j = 0; j < len - i; j ++) {
                if (arrays[j].compareTo(arrays[j+1]) < 0) {
                    T temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                    flag = true;
                }
            }
        }
    }

}
