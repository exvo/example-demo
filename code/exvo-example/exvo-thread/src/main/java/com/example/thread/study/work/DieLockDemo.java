package com.example.thread.study.work;

/**
 * @Date: 2019/10/12$
 * @Author: wy
 * @Description:
 */
public class DieLockDemo {
    public static void main(String[] args) {
        DieLock dl1 = new DieLock(true);
        DieLock dl2 = new DieLock(false);

        dl1.start();
        dl2.start();
    }
}