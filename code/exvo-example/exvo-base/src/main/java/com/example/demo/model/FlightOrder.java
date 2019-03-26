package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Date: 2019/3/25
 * @Author: wu yang
 * @Description:
 */
@Getter
@Setter
public class FlightOrder extends Order {

    static {
        System.out.println("FlightOrder static load...");
    }

    public FlightOrder() {
        System.out.println("FlightOrder load...");
    }
}
