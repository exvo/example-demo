package com.example.demo.generic;

import com.example.demo.generic.model.Monkey;
import com.example.demo.generic.model.Panda;

/**
 * User: wu yang
 * Time: 2018/11/20
 * Description:
 */
public class TwoTuple<A, B> {

    private A a;
    private B b;

    public TwoTuple (A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "a : \t" + a.toString() + "\r\n" +
                "b : \t" + b.toString();
    }

    public static void main(String[] args) {
        TwoTuple<Panda, Monkey> twoTuple = new TwoTuple<>(
                new Panda("熊猫", 12),
                new Monkey("猴子", 15));
        System.out.println(twoTuple);
    }

}
