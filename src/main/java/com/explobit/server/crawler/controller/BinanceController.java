package com.explobit.server.crawler.controller;

import com.explobit.server.crawler.dto.BinanceDto;
import com.explobit.server.crawler.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class BinanceController {

    private final FirebaseService firebaseService;

    @GetMapping("/getBinanceData/{id}")
    public BinanceDto getBinanceData(@PathVariable String id) throws ExecutionException, InterruptedException {
        return firebaseService.getBinanceData(id);
    }

}
