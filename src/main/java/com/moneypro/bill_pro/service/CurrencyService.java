package com.moneypro.bill_pro.service;

import com.moneypro.bill_pro.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.moneypro.bill_pro.repository.CurrencyRepository;

import java.util.List;

/**
 * @author Miles
 * @date 2024/6/29 22:23
 */
@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    public Currency save(Currency currency){
        if(currency.getId() == null){
            currencyRepository.save(currency);
        }else{
            currencyRepository.updateById(currency);
        }
        return currency;
    }

    public List<Currency> findAll(){
        return currencyRepository.list();
    }
}
