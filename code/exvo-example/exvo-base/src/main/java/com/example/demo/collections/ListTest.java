package com.example.demo.collections;

import java.util.*;

/**
 * User: wu yang
 * Time: 2018/11/8
 * Description:
 */
public class ListTest {

    public static void main(String[] args) {
//        iteratorTest();
        listIteratorTest();
    }

    /**
     * iterator迭代器
     */
    public static void iteratorTest() {
        List<String> list = arrayList(20);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
//            System.out.println("hasNext() ----  " + iterator.next());
        }

    }

    /**
     * listIterator迭代器
     */
    public static void listIteratorTest() {
        List<String> list = arrayList(20);
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("hasNext() ----  " + listIterator.nextIndex() + "----" + listIterator.next() + "----" + listIterator.hasPrevious());
        }

    }

    public static List<String> arrayList(int size) {
        List<String>  list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            list.add("A00" + random.nextInt(100));
        }
        return list;
    }


}
