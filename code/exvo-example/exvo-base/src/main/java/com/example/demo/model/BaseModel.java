package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date: 2019/3/25
 * @Author: wu yang
 * @Description:
 */
@Getter
@Setter
@ToString
public class BaseModel {

    private Date createAt;
    private String createBy;

}
