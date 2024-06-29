package com.moneypro.bill_pro.service;

import com.moneypro.bill_pro.domain.Account;
import com.moneypro.bill_pro.domain.Currency;
import com.moneypro.bill_pro.enums.AccountTypes;
import com.moneypro.bill_pro.repository.AccountRepository;
import com.moneypro.bill_pro.repository.CurrencyRepository;
import com.moneypro.bill_pro.vo.BalanceVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
        Currency currency = currencyRepository.getById(currencyId);
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
        List<Account> list = accountRepository.list();
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

}
