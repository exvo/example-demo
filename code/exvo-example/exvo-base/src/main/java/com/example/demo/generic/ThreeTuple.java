package com.example.demo.generic;

import com.example.demo.generic.model.Elephant;
import com.example.demo.generic.model.Monkey;
import com.example.demo.generic.model.Panda;
import lombok.Getter;
import lombok.Setter;

/**
 * User: wu yang
 * Time: 2018/11/20
 * Description:泛型继承
 */
@Getter
@Setter
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

    private C c;


    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\n" +
                "c : \t" + c.toString();
    }

    public static void main(String[] args) {
        ThreeTuple<Panda, Monkey, Elephant> threeTuple = new ThreeTuple<>(
                new Panda("熊猫", 12),
                new Monkey("猴子", 15),
                new Elephant("大象", 18));
        System.out.println(threeTuple);
    }

}
