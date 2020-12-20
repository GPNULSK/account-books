package com.lsk.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_account_book
 * @author 
 */
@Data
public class AccountBook implements Serializable {
    private Integer id;

    private Integer bookId;

    private Date today;

    private Double perCost;

    private String description;

    private Double dayCost;

    private Double monCost;

    private Double monRemainder;

    private Double yearRemainder;

    private static final long serialVersionUID = 1L;
}