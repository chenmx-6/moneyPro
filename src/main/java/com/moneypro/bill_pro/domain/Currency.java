package com.moneypro.bill_pro.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Miles
 * @date 2024/6/29 21:56
 */
@Data
@TableName("currency")
public class Currency extends BaseEntity{
    private String name;
    private Double rate;
}
