package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Date: 2018/11/6
 * @Author: wu yang
 * @Description:保存/提交 出差申请单
 */
@Getter
@Setter
public class SaveTravelApplyRequest {

    private Long id;
    /** 申请单号 **/
    private String orderNo;
    /** 出差类型：H-国内、G-国际 **/
    private String travelType;
    /** 业务类型 **/
    private String bizType;
    /** 记账项目code **/
    private String accountProjectCode;
    /** 开始时间 **/
    private Date startDate;
    /** 结束时间 **/
    private Date endDate;
    /** 是否被招待 0-否 1-是 **/
    private int ifEntertained;
    /** 餐饮（次/天） **/
    private int entertainedNum;
    /** 是否改签 0-否 1-是 **/
    private int ifRefund;
    /** 原始单据号 **/
    private String refundOrderNo;
    /** 备注 **/
    private String remark;

    /** 单据审批状态 **/
    private int approvalStatus;

    /** 出行人 **/
    private List<TravelPassengerRequest> passengerRequests;
    /** 行程 **/
    private List<TravelTripRequest> tripRequests;
    /** 预算 **/
    private List<TravelBudgetRequest> budgetRequests;


}
