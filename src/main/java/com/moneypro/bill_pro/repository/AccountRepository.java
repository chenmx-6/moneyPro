package com.moneypro.bill_pro.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moneypro.bill_pro.domain.Account;
import com.moneypro.bill_pro.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
 * @author Miles
 * @date 2024/6/29 22:19
 */
@Service
public class AccountRepository extends ServiceImpl<AccountMapper, Account> {
}
