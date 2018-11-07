package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Date: 2018/11/6
 * @Author: wu yang
 * @Description:预算
 */
@Getter
@Setter
public class TravelBudgetRequest {

    /** 费用类型id **/
    private String budgetType;
    /** 费用类型名称 **/
    private String budgetTypeName;
    /** 标准价 **/
    private int standardAmount;
    /** 数量 **/
    private int quantity;
    /** 预算额度(标准价 * 数量) **/
    private int budgetAmount;
    /** CNY/USD/HKD  币种 **/
    private String currency;
    /** 关联购物申请单 **/
    private String refPurchaseOrderNo;
    /** 备注 **/
    private String remark;

}
