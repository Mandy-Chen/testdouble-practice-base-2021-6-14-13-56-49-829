package com.tw.comprehensive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TradingServiceTest {
    @Test
    void name1() {
        TradeRepository tradeRepository=mock(TradeRepository.class);
        AuditService auditService=mock(AuditService.class);
        TradingService tradingService=new TradingService(tradeRepository,auditService);
        Trade trade=mock(Trade.class);
        tradingService.createTrade(trade);
        verify(auditService,times(1)).logNewTrade(trade);
    }
    @Test
    void name2() {
        TradeRepository tradeRepository=mock(TradeRepository.class);
        AuditService auditService=mock(AuditService.class);
        TradingService tradingService=new TradingService(tradeRepository,auditService);
        Trade trade=mock(Trade.class);
        Long id=tradingService.createTrade(trade);
        Trade trade1=tradingService.findTrade(id);
        Trade trade2=tradeRepository.findById(id);//mack
        assertEquals (trade1,trade2);
    }
    @Test
    void name3() {
        TradeRepository tradeRepository=mock(TradeRepository.class);
        AuditService auditService=mock(AuditService.class);
        TradingService tradingService=new TradingService(tradeRepository,auditService);
        Trade trade=mock(Trade.class);
        Long id=tradingService.createTrade(trade);
        Trade trade1=tradingService.findTrade(id);
        Trade trade2=tradeRepository.findById(id);
        assertEquals (trade1,trade2);

    }
}