package com.example.demo.main;

import java.util.ArrayList;
import java.util.List;

/**
 * User: wu yang
 * Time: 2018/12/22
 * Description:
 */
public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("234");

        System.out.println(String.format("你好：%s", list));

    }

}
