package com.example.thread.study.work;

import com.example.thread.utils.LogUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2019/9/6$
 * @Author: wy
 * @Description:
 */
public class Test3 {

    private static MyQueue queue = new MyQueue();

    private static volatile LinkedList<String> add = new LinkedList<>();

    private static volatile int getNum = 0;

    /**
     * 使用 wait notify 实现一个队列，队列有2个方法，add 和 get 。
     * add方法往队列中添加元素，get方法往队列中获得元素。
     * 队列必须是线程安全的。如果get执行时，队列为空，线程必须阻塞等待，直到有队列有数据。
     * 如果add时，队列已经满，则add线程要等待，直到队列有空闲空间。
     *
     * @param args
     */
    public static void main(String[] args) {

        Object lock = new Object();

        /**
         * 场景： 队列大小为3
         * add 线程 先添加1次数据，get 线程 取出1次数据
         * add 线程 添加 5次数据， get 线程 取1次数据
         * add 线程 添加 2次数据， get 线程 取6次数据
         */

//         get线程执行的数量
//        final int[] getNum = {0};

        // 控制 添加，获取
        AtomicInteger count = new AtomicInteger();

        Thread addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (add.size() > 0) {
                        try {
                            String first = add.getFirst();
                            System.out.println("添加数据： " + first);
                            queue.add(first);
                            add.removeFirst();
                        } catch (InterruptedException e) {
                            LogUtils.error("添加出错", e);
                        }
                    }
                }
            }
        });
        Thread getThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (getNum > 0) {
                        try {
                            for (int i = 0; i < getNum; i++) {
                                System.out.println("取出数据： " + queue.get());
                            }
                            getNum = 0;
                        } catch (InterruptedException e) {
                            LogUtils.error("获取出错", e);
                        }
                    }
                }
            }
        });


        Thread controlThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    switch (i) {
                        case 1:
                            add.add("1");
                            getNum = 1;
                            break;
                        case 2:
                            add.add("2");
                            add.add("3");
                            add.add("4");
                            add.add("5");
                            add.add("6");
                            getNum = 4;
                            break;
                        case 3:
                            add.add("7");
                            add.add("8");
                            getNum = 6;
                            break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        controlThread.start();
        addThread.start();
        getThread.start();

    }

    static class MyQueue {

        private static Object lock = new Object();

        // 模拟队列
        private static LinkedList<String> queue = new LinkedList<>();

        // 队列大小
        private static final int size = 3;

        private static AtomicInteger count = new AtomicInteger();

        public void add(String value) throws InterruptedException {
            synchronized (lock) {
                while (count.get() == size) {
                    // add线程进入等待
                    lock.wait();
                }
                boolean isAddSuccess = queue.add(value);
                if (isAddSuccess) {
                    count.incrementAndGet();
                    lock.notify();
                }
            }
        }

        public String get() throws InterruptedException {
            synchronized (lock) {
                while (count.get() == 0) {
                    // get线程进入等待
                    lock.wait();
                }
                String first = queue.getFirst();
                boolean isGetSuccess = queue.remove(first);
                if (isGetSuccess) {
                    count.decrementAndGet();
                    lock.notify();
                }
                return first;
            }
        }

    }

}
