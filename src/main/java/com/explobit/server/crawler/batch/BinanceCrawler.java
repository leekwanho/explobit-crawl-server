package com.explobit.server.crawler.batch;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerPrice;
import com.explobit.server.crawler.dto.BinanceDto;
import com.explobit.server.crawler.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import util.DateTimeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class BinanceCrawler {

    private final BinanceApiRestClient binanceApiRestClient;
    private final FirebaseService firebaseService;

    @Scheduled(fixedDelay = 1000 * 60 * 10)
    public void binanceCrawling() throws ExecutionException, InterruptedException {
        String now = DateTimeUtil.getCurDatetime();
        List<Map<String, String>> tickerPriceList = new ArrayList<>();
        for (TickerPrice tickerPrice : binanceApiRestClient.getAllPrices()) {
            Map<String, String> tickerPriceMap = new HashMap<>();
            tickerPriceMap.put("ticker", tickerPrice.getSymbol());
            tickerPriceMap.put("price", tickerPrice.getPrice());
            tickerPriceList.add(tickerPriceMap);
        }
        BinanceDto binanceDto = new BinanceDto(tickerPriceList, now);
        firebaseService.insertBinanceData(binanceDto);
    }

}
