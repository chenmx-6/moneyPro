package com.moneypro.bill_pro.controller;

import com.moneypro.bill_pro.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.moneypro.bill_pro.service.CurrencyService;

import java.util.List;


/**
 * @author Miles
 * @date 2024/6/29 22:21
 */
@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController{
    private final CurrencyService currencyService;

    @PostMapping("/save")
    public Currency save(@RequestBody Currency currency){
        return currencyService.save(currency);
    }

    @GetMapping("/findAll")
    public List<Currency> findAll(){
        return currencyService.findAll();
    }
}
