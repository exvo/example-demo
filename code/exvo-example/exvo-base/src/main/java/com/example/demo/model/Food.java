package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Date: 2019/3/25
 * @Author: wu yang
 * @Description:
 */
@Getter
@Setter
@ToString
public class Food extends BaseModel {

    /**
     * 有效期
     */
    private Date validityPeriod;
    private String name;
    /**
     * 味道
     */
    private String flavor;

}
