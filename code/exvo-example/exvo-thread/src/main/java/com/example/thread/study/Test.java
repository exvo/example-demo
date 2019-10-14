package com.example.thread.study;

/**
 * @Date: 2019/9/6$
 * @Author: wy
 * @Description:
 */
public class Test {

    protected long l = -1l;

    public static void main(String[] args) {
        System.out.println(toBinary(-1l));
        System.out.println(toBinary(1l));
        Test t = new Test();
        Worker w1 = new Worker(t);
        Worker2 w2 = new Worker2(t);
        w1.setDaemon(true);
        w2.setDaemon(true);
        w1.start();
        w2.start();
        while (true) {
            long temp = t.l;
            String str = toBinary(temp);
            if (!str.equals("0000000000000000000000000000000000000000000000000000000000000001")
                    && !str.equals("1111111111111111111111111111111111111111111111111111111111111111")) {
                System.out.println("l的写不是原子操作");
                System.out.println(temp);
                System.out.println(str);
                break;
            }
        }
    }

    private static String toBinary(long l) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(l));
        while (sb.length() < 64) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}

class Worker extends Thread {

    public Worker(Test t) {
        this.t = t;
    }

    private Test t;

    public void run() {
        while (true) {
            t.l = -1l;
        }
    }
}

class Worker2 extends Thread {

    public Worker2(Test t) {
        this.t = t;
    }

    private Test t;

    public void run() {
        while (true) {
            t.l = 1l;
        }
    }


}
