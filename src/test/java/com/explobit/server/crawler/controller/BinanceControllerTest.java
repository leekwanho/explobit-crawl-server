package com.explobit.server.crawler.controller;

import com.explobit.server.crawler.dto.BinanceDto;
import com.explobit.server.crawler.service.FirebaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BinanceControllerTest {

    @InjectMocks
    private BinanceController binanceController;
    @Mock
    private FirebaseService firebaseService;

    @Test
    public void test() throws Exception {
        //given
        List<Map<String, String>> list = new ArrayList<>();
        BinanceDto binanceDto = new BinanceDto(list, "test");
        given(firebaseService.getBinanceData(anyString())).willReturn(binanceDto);

        //when
        BinanceDto result = binanceController.getBinanceData("1");

        //then
        assertEquals(result, binanceDto);
    }

}