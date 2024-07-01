package com.moneypro.bill_pro.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.moneypro.bill_pro.enums.AccountTypes;
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
    @TableField(exist = false)
    private BigDecimal debt;
    @TableField(exist = false)
    private BigDecimal debitCardBalance;
    @TableField(exist = false)
    private BigDecimal realBalance;

    public BigDecimal getDebt() {
        if(AccountTypes.CREDIT_CARD.getCode().equals(type)){
            return balance;
        }
        return null;
    }

    public BigDecimal getDebitCardBalance() {
        if(!AccountTypes.CREDIT_CARD.getCode().equals(type)){
            return balance;
        }
        return null;
    }

    public BigDecimal getRealBalance() {
        if(AccountTypes.CREDIT_CARD.getCode().equals(type)){
            return BigDecimal.ZERO.subtract(cnyBalance);
        }else{
            return cnyBalance;
        }
    }




}
