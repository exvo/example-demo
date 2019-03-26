package com.example.demo.compare;

/**
 * @Date: 2019/3/26
 * @Author: wu yang
 * @Description:
 */
public class BitOperation {

    /**
     * 位运算
     * << 左移运算符 乘
     * >> 右移运算符 除
     * >>> 忽略符号 右移运算符 除
     * 个人理解  8 << 2 (8*2^2)   8 >> 2 (8/2^2)  8 >>> 2 (8/2^2)
     * @param args
     */
    public static void main(String[] args) {
        System.out.println((-8) << 3); // -64
        System.out.println(-8 >> 2); // -2
        System.out.println(8 >>> 2);// 2

        System.out.println(29 >>> 1);
    }

}
