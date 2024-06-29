package com.moneypro.bill_pro.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moneypro.bill_pro.domain.Trade;
import com.moneypro.bill_pro.mapper.TradeMapper;
import org.springframework.stereotype.Service;

/**
 * @author Miles
 * @date 2024/6/29 22:15
 */
@Service
public class TradeRepository extends ServiceImpl<TradeMapper, Trade> {
}
