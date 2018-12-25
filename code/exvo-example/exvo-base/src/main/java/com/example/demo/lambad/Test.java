package com.example.demo.lambad;

import com.example.demo.model.User;

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

}
