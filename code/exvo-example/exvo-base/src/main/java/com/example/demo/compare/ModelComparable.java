package com.example.demo.compare;

import java.util.Comparator;

/**
 * @Date: 2019/3/26
 * @Author: wu yang
 * @Description:
 */
public class ModelComparable<T extends BaseModel> implements Comparator<T> {

    @Override
    public int compare(T t1, T t2) {
        return t1.getName().compareTo(t2.getName());
    }
}
