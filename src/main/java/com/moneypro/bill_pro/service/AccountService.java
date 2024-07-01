package com.moneypro.bill_pro.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.moneypro.bill_pro.domain.Account;
import com.moneypro.bill_pro.domain.Currency;
import com.moneypro.bill_pro.enums.AccountTypes;
import com.moneypro.bill_pro.repository.AccountRepository;
import com.moneypro.bill_pro.repository.CurrencyRepository;
import com.moneypro.bill_pro.vo.BalanceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Miles
 * @date 2024/6/30 0:32
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final CurrencyRepository currencyRepository;

    public Account save(Account account){
        Long currencyId = account.getCurrencyId();
        Currency currency=null;
        if(currencyId==null){
            currency = currencyRepository.getByName("CNY");
            account.setCurrencyId(currency.getId());
        }else{
            currency = currencyRepository.getById(currencyId);
        }

        BigDecimal rate = currency.getRate().divide(new BigDecimal(100));
        account.setCnyBalance(account.getBalance().multiply(rate));
        if(account.getId() == null){
            accountRepository.save(account);
        }else{
            accountRepository.updateById(account);
        }
        return account;
    }

    public List<Account> findAll(){
        return accountRepository.list();
    }

    public BalanceVo findAllBalance(){
        List<Account> list = accountRepository.list(getLambdaQueryWrapper());
        BigDecimal totalAmount=BigDecimal.ZERO;
        for (Account account : list) {
            if(AccountTypes.CREDIT_CARD.equals(account.getType())){
                totalAmount = totalAmount.subtract(account.getCnyBalance());
            }else{
                totalAmount = totalAmount.add(account.getCnyBalance());
            }
        }
        BalanceVo balanceVo = new BalanceVo();
        balanceVo.setBalance(totalAmount);
        balanceVo.setAccounts(list);
        return balanceVo;
    }

    public LambdaQueryWrapper<Account> getLambdaQueryWrapper(){
        LambdaQueryWrapper<Account> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Account::getCnyBalance);
        return lambdaQueryWrapper;
    }

    public Map<String,String> getAccountTypes(){
        Map<String,String> map = new HashMap<>();
        for (AccountTypes value : AccountTypes.values()) {
            map.put(value.getCode(),value.getDesc());
        }
        return map;
    }

}
