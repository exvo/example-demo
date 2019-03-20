package com.example.thread.threadTest;

/**
 * @Date: 2019/3/20
 * @Author: wu yang
 * @Description:
 */
public class VolatileTest extends Thread {

    private boolean flag = false;

    public void change() {
        this.flag = true;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        VolatileTest v1 = new VolatileTest();
        VolatileTest v2 = new VolatileTest();
        v1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v1.change();
        v2.start();


    }

}
