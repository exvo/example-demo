package com.example.demo.model;

/**
 * @Date: 2018/12/21
 * @Author: wu yang
 * @Description:
 */
public class Student {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

}
