package com.moneypro.bill_pro.domain;

import lombok.Data;

/**
 * @author Miles
 * @date 2024/6/29 22:05
 */
@Data
public class Account extends BaseEntity{
    private String name;
    private String type;
    private Double balance;
    private Long currencyId;
    private Double cnyBalance;
}
