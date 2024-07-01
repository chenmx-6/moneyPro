package com.moneypro.bill_pro.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moneypro.bill_pro.domain.Currency;
import com.moneypro.bill_pro.mapper.CurrencyMapper;
import org.springframework.stereotype.Service;

/**
 * @author Miles
 * @date 2024/6/29 22:13
 */
@Service
public class CurrencyRepository extends ServiceImpl<CurrencyMapper, Currency> {

    public Currency getByName(String name){
        return this.lambdaQuery().eq(Currency::getName, name).one();
    }
}
