package com.example.demo.generic.model;

import lombok.Getter;
import lombok.Setter;

/**
 * User: wu yang
 * Time: 2018/11/20
 * Description:
 */
@Getter
@Setter
public class People {

    private String name;
    private int age;

    public People (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "---- name: \t" + name + "\t" +
                "--age: \t" + age + "\r\n";
    }

}
