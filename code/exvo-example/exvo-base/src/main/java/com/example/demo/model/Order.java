package com.example.demo.model;

import lombok.Getter;
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

    public Order(String orderNo, Double amount) {
        this.orderNo = orderNo;
        this.amount = amount;
    }
}
