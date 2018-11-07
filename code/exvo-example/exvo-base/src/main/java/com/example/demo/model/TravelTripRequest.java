package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Date: 2018/11/6
 * @Author: wu yang
 * @Description: 出差行程
 */
@Getter
@Setter
public class TravelTripRequest {

    /** 开始时间 **/
    private Date startDate;
    /** 结束时间 **/
    private Date endDate;
    /** 出发城市code **/
    private String startCityCode;
    /** 出发城市名称 **/
    private String startCityName;
    /** 到达城市code **/
    private String toCityCode;
    /** 到达城市名称 **/
    private String toCityName;
    /** 出行方式 **/
    private String tripType;
    /** 出行方式名称 **/
    private String tripTypeName;
    /** 是否需要住宿 0：否，1：是 **/
    private int ifHotel;
    /** 是否指定酒店：0-非指定酒店，1-指定酒店 **/
    private int ifAssignedHotel;
    /** 备注 **/
    private String remark;

}
