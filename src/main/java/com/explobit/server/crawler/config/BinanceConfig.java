package com.explobit.server.crawler.config;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BinanceConfig {

    @Bean
    public BinanceApiRestClient binanceInitialize() {
        BinanceApiClientFactory factory =
                BinanceApiClientFactory.newInstance(
                        "ejrPiM7iA8HIYqKxNIit9ANeXZfY6RwRCvV1kYQvPLs7qeICc7rQ5VqsU9VqeFyX",
                        "rb9mHcydDKGAUZUMlzDog0gvH9nAaCoHLSwaxpxCWA5nXymDZzmFLQMCUI34KY84");
        return factory.newRestClient();
    }

}
