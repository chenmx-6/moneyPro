package com.moneypro.bill_pro.vo;

import com.moneypro.bill_pro.domain.Account;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Miles
 * @date 2024/6/30 1:14
 */
@Data
public class BalanceVo {
    private BigDecimal balance;
    private List<Account> accounts;
}
