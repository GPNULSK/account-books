package com.lsk.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_userinfo
 * @author 
 */
@Data
public class Userinfo implements Serializable {
    /**
     * 用于ID
     */
    private Integer uid;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 开始记账的日期
     */
    private Date startDate;

    /**
     * 一个月的总存款
     */
    private Double totalMoney;

    /**
     * 总消费
     */
    private Double totalCost;

    /**
     * 月剩余的存款
     */
    private Double monDeposit;

    /**
     * 年剩余的存款
     */
    private Double yearDeposit;

    private static final long serialVersionUID = 1L;
}