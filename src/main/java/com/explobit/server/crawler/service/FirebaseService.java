package com.explobit.server.crawler.service;

import com.explobit.server.crawler.dto.BinanceDto;

import java.util.concurrent.ExecutionException;

public interface FirebaseService {

    String insertBinanceData(BinanceDto binanceDto) throws ExecutionException, InterruptedException;

    BinanceDto getBinanceData(String id) throws ExecutionException, InterruptedException;

}
