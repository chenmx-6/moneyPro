package com.moneypro.bill_pro.controller;

import com.moneypro.bill_pro.domain.Account;
import com.moneypro.bill_pro.service.AccountService;
import com.moneypro.bill_pro.vo.BalanceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Miles
 * @date 2024/6/30 0:43
 */
@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @RequestMapping("save")
    public Account save(@RequestBody @Validated Account account){
        return accountService.save(account);
    }

    @RequestMapping("findAll")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @RequestMapping("queryAllBalance")
    public BalanceVo queryAllBalance(){
        return accountService.findAllBalance();
    }

}
