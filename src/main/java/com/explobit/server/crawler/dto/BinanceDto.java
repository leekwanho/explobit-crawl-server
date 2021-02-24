package com.explobit.server.crawler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class BinanceDto {

    private List<Map<String, String>> tickerPrice;
    private String createTime;

}
