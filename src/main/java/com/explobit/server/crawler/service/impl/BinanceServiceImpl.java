package com.explobit.server.crawler.service.impl;

import com.explobit.server.crawler.dto.BinanceDto;
import com.explobit.server.crawler.service.FirebaseService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class BinanceServiceImpl implements FirebaseService {

    @Value("${firebase-database.binance-collection-name}")
    private String binanceCollectionName;
    private final Firestore firestore;

    @Override
    public String insertBinanceData(BinanceDto binanceDto) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> apiFuture =
                firestore.collection(binanceCollectionName).document().set(binanceDto);

        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public BinanceDto getBinanceData(String id) throws ExecutionException, InterruptedException {
        DocumentReference documentReference =
                firestore.collection(binanceCollectionName).document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        if (documentSnapshot.exists()) {
            return documentSnapshot.toObject(BinanceDto.class);
        } else {
            return null;
        }
    }

}
