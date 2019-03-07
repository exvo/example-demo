package com.example.demo.main;

import com.example.demo.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Date: 2018/12/26
 * @Author: wu yang
 * @Description:
 */
public class Test1 {

    public static void main(String[] args) {
        /*Order order1 = new Order("001", 20D);
        Order order2 = new Order("002", 24D);
        Order order3 = new Order("003", 26D);
        Order order4 = new Order("004", 30D);

        List<Order> orders = new ArrayList<Order>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);

        Optional<Double> reduce = orders.stream().map(Order::getAmount).reduce(Double::sum);
        System.out.println(reduce.get());

        System.out.println("----------------");
        System.out.println();*/

       /* Double d = null;
        Double s = 2.2;
        d = d == null ? 0D : d;
        System.out.println(d+s);*/

       String str = " a b c d ";
        System.out.println(str.trim());


    }

}
