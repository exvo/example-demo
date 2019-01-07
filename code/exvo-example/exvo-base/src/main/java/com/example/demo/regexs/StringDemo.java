package com.example.demo.regexs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Date: 2018/11/13
 * @Author: wu yang
 * @Description:
 */
public class StringDemo {
    static Integer a;

    public static void main(String[] args) {
        /*String str = "AAA000";
        String regex = "^AAA+\\d";
        System.out.println(Pattern.matches(regex, str));

        System.out.println(str.matches(regex));*/

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("你好");
        list.add("的说法是");
        list.add("地方都是");
        list.add("的发热管");
        list.add("额");

//        System.out.println(String.join(",", list));


        System.out.println(a > 0);

    }

}
