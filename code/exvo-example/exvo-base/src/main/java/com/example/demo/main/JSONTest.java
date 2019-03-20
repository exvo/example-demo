package com.example.demo.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.Student;

/**
 * @Date: 2019/3/18
 * @Author: wu yang
 * @Description:
 */
public class JSONTest {

    public static void main(String[] args) {

        Student st = new Student(23, "张三");
        String s = JSON.toJSONString(st);
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject);
    }

}
