package com.example.thread.utils;

/**
 * @Date: 2019/9/6$
 * @Author: wy
 * @Description:
 */
public class LogUtils {

    public static void error(String msg, Exception e) {
        System.err.println("error: " + msg + " \r\n" + e);
    }

}
