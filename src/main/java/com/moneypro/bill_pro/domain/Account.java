package com.moneypro.bill_pro.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Miles
 * @date 2024/6/29 22:05
 */
@Data
public class Account extends BaseEntity{
    private String name;
    private String type;
    private BigDecimal balance;
    @NotNull(message = "currencyId不能为空")
    private Long currencyId;
    private BigDecimal cnyBalance;
}
