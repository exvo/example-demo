package com.example.thread.threadTest;

import jdk.nashorn.internal.runtime.regexp.RegExp;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Date: 2019/3/8
 * @Author: wu yang
 * @Description:
 */
public class Test2 {

    private static int num;

    /**
     * synchronized对象锁
     * 一个对象一把锁, 不同对象的线城可以同时进入方法
     * 多个对象之间没有影响，加上static之后多个对象使用同一把锁，必须等待上一个线程执行完成
     * @param tar
     * @throws InterruptedException
     */
    private static synchronized void print(String tar) throws InterruptedException {
        if (tar.equals("a")) {
            num = 100;
            System.out.println("tar " + tar + " set num over");
            Thread.sleep(100);
        } else {
            num = 200;
            System.out.println("tar " + tar + " set num over");
        }

        System.out.println("tar " + tar + " num " + num);
    }

    public static void main(String[] args) {

        final Test2 t1 = new Test2();
        final Test2 t2 = new Test2();

        Thread th1 = new Thread(new Runnable() {
            public void run() {
                try {
                    print("a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            public void run() {
                try {
                    print("b");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        th1.start();
        th2.start();

    }

}
