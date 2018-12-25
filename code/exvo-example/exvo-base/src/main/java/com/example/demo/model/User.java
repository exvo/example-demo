package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Date: 2018/12/17
 * @Author: wu yang
 * @Description:
 */
@Getter
@Setter
@ToString
public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }



}
