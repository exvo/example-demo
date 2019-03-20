package com.example.demo.utils;

import com.example.demo.model.Order;
import com.example.demo.model.Student;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * User: f_wy
 * Time: 2019/3/20
 * Description:
 */
public class QueryTypeUtils {

    public static String buildUpType (Object obj) {
        Class<?> c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        List<String> result = new ArrayList<>();
        for (Field field : fields) {
            String fileName = field.getName();
            String getMethods = "get" + toUpperCaseFirstOne(fileName);
            try {
                Method method = c.getMethod(getMethods, new Class[]{});
                Object value = method.invoke(obj);
                if (value != null) {
                    result.add(" " + fileName + " = '" + value + "' ");
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (CollectionUtils.isNotEmpty(result)) {
            String resultStr = " where " + String.join("and", result);
            return resultStr;
        }
        return "";
    }

    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }



    public static void main(String[] args) {
        Order order = new Order();
        order.setAmount(23.5);
        order.setOrderNo("ASD123");
        order.setType("345");

//        Student student = new Student();

        String sql = "select * from order";

        String params = QueryTypeUtils.buildUpType(order);
        if (params != null && !params.isEmpty()) {
            sql += params;
        }

        System.out.println(sql);

    }

}
