package com.example.demo.lambad;

import com.example.demo.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2018/12/17
 * @Author: wu yang
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        BigDecimal a = BigDecimal.valueOf(1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("2600").multiply(new BigDecimal(0.6));
        System.out.println(b);
        System.out.println(b.multiply(a));

//        test2();
    }

    public void trst1() {
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 21));
        users.add(new User("李四", 22));
        users.add(new User("王五", 23));
        users.add(new User("赵六", 24));
        users.add(new User("Marry", 25));
        users.add(new User("Bob", 26));
        users.add(new User("Lei", 27));

//        users.stream().forEach(u -> System.out.println(u));
//        users.stream().limit(2).forEach(user -> System.out.println(user));
    }

    public static void test2() {
        new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }.run();

        Runnable r = () -> {
            System.out.println("lambad表达式");
        };
        r.run();

    }


}
