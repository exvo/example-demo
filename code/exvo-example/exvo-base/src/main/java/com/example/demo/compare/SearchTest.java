package com.example.demo.compare;

import java.util.Comparator;

/**
 * @Date: 2019/3/26
 * @Author: wu yang
 * @Description:
 */
public class SearchTest {

    private static Integer[] arrays = {2, 4, 6, 32, 34, 36, 43, 45, 55, 56, 58, 67, 94, 200, 433, 578, 789, 900};

    public static void main(String[] args) {
        /**
         * 普通数组
         */
        /*int index = binarySearch1(arrays, 58, Integer::compareTo);
        if (index >= 0) {
            System.out.println(arrays[index]);
        } else {
            System.out.println("no data");
        }*/
        /** 递归方法 */
        int index = binarySearch2(arrays, 4, 0, arrays.length - 1, Integer::compareTo);
        if (index >= 0) {
            System.out.println(index);
            System.out.println(arrays[index]);
        } else {
            System.out.println("no data");
        }

        /**
         * 对象数组，需要自定义比较器
         */
        /*Model model1 = new Model();
        Model model2 = new Model();
        Model model3 = new Model();

        model1.setName("123");
        model2.setName("456");
        model3.setName("789");

        List<Model> models = new ArrayList<>();
        models.add(model1);
        models.add(model2);
        models.add(model3);

        int index = binarySearch1(models.toArray(), model3, new ModelComparable());
        if (index >= 0) {
            System.out.println(models.get(index));
        } else {
            System.out.println("no data");
        }*/
    }

    /**
     * 循环二分查找法
     *
     * @param array      待查找数组
     * @param key        查找数据
     * @param comparator 比较器
     * @param <T>
     * @return 返回下标
     */
    public static <T> int binarySearch11(T[] array, T key, Comparator<T> comparator) {
        // 每次比较范围最小下标
        int midIndex = 0;
        // 数组长度
        int length = array.length - 1;
        while (midIndex <= length) {
            // 每次查找的中间下标
            int searchIndex = (midIndex + length) >>> 1;
            int compare = comparator.compare(key, array[searchIndex]);
            if (compare > 0) {
                midIndex = searchIndex + 1;
            } else if (compare < 0) {
                length = searchIndex - 1;
            } else {
                return searchIndex;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找法
     *
     * @param array
     * @param key
     * @param midIndex   每次比较范围最小下标
     * @param length     数组长度
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T> int binarySearch2(T[] array, T key, int midIndex, int length, Comparator<T> comparator) {
        if (midIndex <= length) {
            int searchIndex = (midIndex + length) >>> 1;
            int compare = comparator.compare(key, array[searchIndex]);
            if (compare > 0) {
                midIndex = searchIndex + 1;
                return binarySearch2(array, key, midIndex, length, comparator);
            } else if (compare < 0) {
                length = searchIndex - 1;
                return binarySearch2(array, key, midIndex, length, comparator);
            } else {
                return searchIndex;
            }
        }
        return -1;
    }

}
