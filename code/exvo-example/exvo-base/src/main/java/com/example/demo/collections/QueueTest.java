package com.example.demo.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: wu yang
 * Time: 2018/11/8
 * Description:队列 先进先出
 */
public class QueueTest {

    public static void main(String[] args) {
        //TODO PriorityQueue先进先出描述了最典型的队列规则  可以进行排序

        Queue<String> stringQueue = init(6);
        System.out.println(stringQueue);

        poll(stringQueue);
        System.out.println(stringQueue);

        peek(stringQueue);
        System.out.println(stringQueue);

        element(stringQueue);
        System.out.println(stringQueue);

        remove(stringQueue);
        System.out.println(stringQueue);

    }

    /**
     * Queue 是一个接口，所以将LinkList向上转型为QUEUE
     * @param size
     * @return
     */
    public static Queue<String> init(int size) {
        Queue<String> stringQueue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            offer(stringQueue, "A00" + i);
        }
        return stringQueue;
    }

    /**
     * 向队列中插入一条数据
     * @param queue
     * @param value
     */
    public static void offer(Queue<String> queue, String value) {
        queue.offer(value);
    }

    /**
     * 返回队列 头部数据  为空时返回null
     * @param queue
     */
    public static void peek(Queue<String> queue) {
        System.out.println("peek()  ----" + queue.peek());
    }

    /**
     * 返回队列 头部数据  为空时报错
     * @param queue
     */
    public static void element(Queue<String> queue) {
        System.out.println("element()  ----" + queue.element());
    }

    /**
     * 移除队列 头部数据  并返回  为空时返回null
     * @param queue
     */
    public static void poll(Queue<String> queue) {
        System.out.println("poll()  ----" + queue.poll());
    }

    /**
     * 移除队列 头部数据  并返回  为空时报错
     * @param queue
     */
    public static void remove(Queue<String> queue) {
        System.out.println("remove()  ----" + queue.remove());
    }

}
