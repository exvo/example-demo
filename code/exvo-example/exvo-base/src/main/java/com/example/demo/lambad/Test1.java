package com.example.demo.lambad;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Date: 2019/4/23
 * @Author: wu yang
 * @Description:
 */
public class Test1 {

    public static void main(String[] args) {
//        Stream.generate(() -> RandomUtils.nextInt(10, 20)).limit(5).forEach(System.out::println);

        Optional<Integer> first = Stream.of(2, 5, 1, 8, 10).filter(s -> s > 5).findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        }
    }

}
