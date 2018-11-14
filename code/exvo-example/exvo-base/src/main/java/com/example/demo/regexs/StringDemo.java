package com.example.demo.regexs;

import java.util.regex.Pattern;

/**
 * @Date: 2018/11/13
 * @Author: wu yang
 * @Description:
 */
public class StringDemo {

    public static void main(String[] args) {
        String str = "AAA000";
        String regex = "^AAA+\\d";
        System.out.println(Pattern.matches(regex, str));

        System.out.println(str.matches(regex));
    }

}
