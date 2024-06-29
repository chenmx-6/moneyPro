package com.moneypro.bill_pro.service;

import com.moneypro.bill_pro.domain.Account;
import com.moneypro.bill_pro.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miles
 * @date 2024/6/30 0:32
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    public Account save(Account account){
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

}
