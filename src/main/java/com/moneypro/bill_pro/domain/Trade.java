package com.moneypro.bill_pro.domain;

import lombok.Data;

/**
 * @author Miles
 * @date 2024/6/29 22:02
 */
@Data
public class Trade extends BaseEntity{
    private Long fromAccountId;
    private Long toAccountId;
    private Double cnyAmount;
    private Long fromCurrencyId;
    private Long toCurrencyId;
    private Double fromAmount;
    private Double fromRate;
    private Double toAmount;
    private Double toRate;
}
