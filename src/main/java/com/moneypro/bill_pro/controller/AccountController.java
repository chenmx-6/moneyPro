package com.moneypro.bill_pro.controller;

import com.moneypro.bill_pro.domain.Account;
import com.moneypro.bill_pro.domain.Currency;
import com.moneypro.bill_pro.service.AccountService;
import com.moneypro.bill_pro.service.CurrencyService;
import com.moneypro.bill_pro.vo.BalanceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author Miles
 * @date 2024/6/30 0:43
 */
@Controller
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final CurrencyService currencyService;


    @RequestMapping("add")
    public ModelAndView add(){
        Map<String, String> accountTypes = accountService.getAccountTypes();
        List<Currency> currencies = currencyService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountTypes",accountTypes);
        modelAndView.addObject("currencies",currencies);
        modelAndView.addObject("account",new Account());
        modelAndView.setViewName("addAccount");
        return modelAndView;
    }

    @PostMapping(value="save")
    public ModelAndView save(@ModelAttribute @Validated Account account){
        accountService.save(account);
        return this.queryAllBalance();
    }

    @RequestMapping("findAll")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @RequestMapping("queryAllBalance")
    public ModelAndView queryAllBalance(){
        BalanceVo balanceVo = accountService.findAllBalance();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("accounts");
        modelAndView.addObject("balanceVo",balanceVo);
        return modelAndView;
    }

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
