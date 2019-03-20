package com.example.thread.threadTest;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2019/3/8
 * @Author: wu yang
 * @Description:
 */
public class Test1 extends Thread {

    private int count = 5;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count =" + count);
    }

    public static void main(String[] args) {

        Test1 test1 = new Test1();

        Thread t1 = new Thread(test1, "t01");
        Thread t2 = new Thread(test1, "t02");
        Thread t3 = new Thread(test1, "t03");
        Thread t4 = new Thread(test1, "t04");
        Thread t5 = new Thread(test1, "t05");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}
