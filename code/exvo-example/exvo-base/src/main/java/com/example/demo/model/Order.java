package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Date: 2018/12/27
 * @Author: wu yang
 * @Description:
 */
@Getter
@Setter
public class Order {

    private String orderNo;
    private Double amount;
    private String num;
    private String type;

    static {
        System.out.println("Order static load...");
    }

    public Order() {
        System.out.println("Order load...");
    }
}
