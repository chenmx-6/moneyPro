package com.moneypro.bill_pro.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Miles
 * @date 2024/6/30 0:40
 */
@Getter
@AllArgsConstructor
public enum AccountTypes {
    CASH("CASH", "现金"),
    DEBIT_CARD("DEBIT_CARD", "储蓄卡"),
    CREDIT_CARD("CREDIT_CARD", "信用卡");

    private final String code;
    private final String desc;

}
