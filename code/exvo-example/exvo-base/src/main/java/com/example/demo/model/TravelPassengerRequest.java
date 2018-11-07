package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Date: 2018/11/6
 * @Author: wu yang
 * @Description: 出行人
 */
@Getter
@Setter
public class TravelPassengerRequest {

    /** 用户工号 **/
    private String employeeNo;
    /** 出行人姓名 **/
    private String passengerName;
    /** 证件类型 **/
    private String identityType;
    /** 证件号 **/
    private String identityNo;

}
