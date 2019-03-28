package com.example.thread.threadTest;

/**
 * @Date: 2019/3/28
 * @Author: wu yang
 * @Description: 内部内单例，多线程下最安全的
 */
public class InnerSingleton {

    private static class Singleton {
        private static Singleton Singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        return Singleton.Singleton;
    }

}
