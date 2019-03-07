package com.example.demo.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Date: 2019/3/5
 * @Author: wu yang
 * @Description:
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("q", "1");
        map.put("w", "2");
        map.put("e", "3");
        map.put("r", "4");


        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey());
        }


    }

}
