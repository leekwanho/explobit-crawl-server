package com.explobit.server.crawler.controller;

import com.explobit.server.crawler.dto.BinanceDto;
import com.explobit.server.crawler.service.FirebaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        BinanceDto binanceDto = new BinanceDto();
        given(firebaseService.getBinanceData(anyString())).willReturn(binanceDto);

        //when
        BinanceDto result = binanceController.getBinanceData("1");

        //then
        assertEquals(result, binanceDto);
    }

}