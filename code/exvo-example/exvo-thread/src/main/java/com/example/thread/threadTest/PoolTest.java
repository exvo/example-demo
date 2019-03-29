package com.example.thread.threadTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2019/3/29
 * @Author: wu yang
 * @Description:
 */
public class PoolTest {

    public static void main(String[] args) {

        /**
         * 有风险的线程池创建
         * 不过底层代码都是通过new ThreadPoolExecutor()创建的线程池，所以我们也可以手动通过new ThreadPoolExecutor()去创建自己需要的线程池
         */
        /*Executors.newFixedThreadPool(10);

        Executors.newCachedThreadPool();

        Executors.newSingleThreadExecutor();

        Executors.newScheduledThreadPool(10);*/

        /**
         * ThreadPoolExecutor 类构造方法
         * @param corePoolSize       当前核心线程数
         * @param maximumPoolSize    最大线程数
         * @param keepAliveTime      线程保持空闲时间
         * @param unit
         * @param workQueue the queue to use for holding tasks before they a
         *        executed.  This queue will hold only the {@code Runnable}
         *        tasks submitted by the {@code execute} method.
         * @param handler the handler to use when execution is blocked
         *        because the thread bounds and queue capacities are reached
         */
        /*
        public ThreadPoolExecutor(int corePoolSize,
                                  int maximumPoolSize,
                                  long keepAliveTime,
                                  TimeUnit unit,
                                  BlockingQueue<Runnable> workQueue,
                                  RejectedExecutionHandler handler) {
            this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                    Executors.defaultThreadFactory(), handler);
        }
        */

    }

}
