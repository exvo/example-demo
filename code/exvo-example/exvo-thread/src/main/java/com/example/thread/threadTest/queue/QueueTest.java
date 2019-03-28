package com.example.thread.threadTest.queue;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2019/3/27
 * @Author: wu yang
 * @Description: 阻塞队列
 * 创建一个队列，声明长度后，一个put方法存入数据，get方法取出数据。当队列中数据等于maxSize时put方法进入等待，等待列中数据小于maxSize时存入数据
 */
public class QueueTest {

    /**
     * 模拟一个队列，存放数据
     */
    private LinkedList<Object> linkedList = new LinkedList<Object>();

    /**
     * 计数器，统计队列中的数据量
     * 原子操作的int,多线程下的i++原子操作
     */
    private AtomicInteger count = new AtomicInteger();

    /**
     * 队列中存放最小数量
     */
    private final int minSize = 0;
    /**
     * 队列中存放最大数量
     */
    private final int maxSize;

    /**
     * 初始化一个对象，用于加锁
     * @param maxSize
     */
    private final Object lock = new Object();

    public QueueTest(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 存入obj
     * @param obj
     */
    public void put(Object obj) {
        synchronized (lock) {
            System.out.println("put obj start obj: " + JSON.toJSONString(obj));
            while (count.get() == maxSize) {
                // 队列已满 线程进入等待
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean add = linkedList.add(obj);
            if (add) {
                count.incrementAndGet();
                System.out.println("put obj success");
                lock.notify();
            } else {
                throw new RuntimeException("存入失败");
            }
        }
    }

    /**
     * 从队列中取元素
     * @return
     */
    public Object get() {
        synchronized (lock) {
            System.out.println("get obj start");
            while (count.get() == minSize) {
                // 队列数据已空 线程进入等待
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object obj = linkedList.getFirst();
            // 移除去除的数据
            boolean remove = linkedList.remove(obj);
            if (remove) {
                count.decrementAndGet();
                System.out.println("get obj success");
                lock.notify();
                return obj;
            } else {
                throw new RuntimeException("获取失败");
            }
        }
    }

    public void showQueueData () {
        System.out.println("**********************");
        linkedList.forEach(System.out::println);
        System.out.println("**********************");
    }

    /**
     * 显示当前队列中数量
     */
    public void showQueueNum() {
        int i = count.get();
        System.out.println("Queue current num: " + i);
    }

}

class Main1 {
    public static void main(String[] args) {
        QueueTest queue = new QueueTest(2);
        queue.put("a");
        queue.put("b");

        queue.showQueueData();;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("c");
                queue.put("d");
            }
        });

        t1.start();

        queue.showQueueData();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Object o = queue.get();
                System.out.println("取出的数据" + o);
            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.showQueueData();
    }
}

class Main {

    private static Thread[] threads;

    public static void main(String[] args) {
        System.out.println("请输入线程数量");
        Scanner scanner = new Scanner(System.in);
        int threadNum = scanner.nextInt();
        init(threadNum);
        System.out.println("请输入队列最大值");
        int queueNum = scanner.nextInt();
        QueueTest queue = new QueueTest(queueNum);
        for (Thread thread : threads) {
            System.out.println("请输入线程名称");
            String threadName = scanner.next();
            thread.setName(threadName);

            System.out.println("请输入操作方法");
            String methodName = scanner.next();

            String data = "";

            Class<? extends QueueTest> queueClass = queue.getClass();
            try {
                Method method;
                if ("put".equals(methodName)) {
                    System.out.println("请输入put数据");
                    data = scanner.next();
                    method = queueClass.getMethod(methodName, new Class[]{Object.class});
                } else {
                    method = queueClass.getMethod(methodName);
                }
                if (data.equals("")) {
                    method.invoke(queue);
                } else {
                    method.invoke(queue, new Object[]{data});
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadNum);
    }

    private static void init(int num) {
        threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread();
        }
    }

}
