package com.example.demo.main;

import com.alibaba.fastjson.JSON;

/**
 * @Date: 2019/4/12
 * @Author: wu yang
 * @Description:
 */
public class Test02 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.main();
    }

    static class Solution {

        public void main() {
            char[] car = {'h','e','l','l','o'};
            System.out.println(car);
            reverseString(car);
            System.out.println(car);
        }

        public void reverseString(char[] s) {
            long l = System.currentTimeMillis();
            reverse(s, 0);
            System.out.println(l - System.currentTimeMillis());
        }

        public void reverse(char[] s, int index) {
            if (s == null) return;
            int length = s.length;
            int begin = index;
            int end = length - index - 1;
            if (begin >= end) return;
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            reverse(s, ++index);
        }
    }


}
