package com.explobit.server.crawler.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class BinanceServiceImplTest {

    @InjectMocks
    private BinanceServiceImpl binanceService;
    @Mock
    private Firestore firestore;

    @BeforeEach
    public void setUp() {
        binanceService = new BinanceServiceImpl(firestore);
    }

    @Test
    public void test() throws Exception {
        //given
        CollectionReference mockCollectionReference = mock(CollectionReference.class);
        DocumentReference mockDocumentReference = mock(DocumentReference.class);
        ApiFuture<DocumentSnapshot> mockApiFuture = mock(ApiFuture.class);
        DocumentSnapshot mockDocumentSnapshot = mock(DocumentSnapshot.class);

        given(firestore.collection(null)).willReturn(mockCollectionReference);
        given(mockCollectionReference.document(anyString())).willReturn(mockDocumentReference);
        given(mockDocumentReference.get()).willReturn(mockApiFuture);
        given(mockApiFuture.get()).willReturn(mockDocumentSnapshot);

        //when
        binanceService.getBinanceData("1");

        //then
        verify(firestore, times(1)).collection(null);
    }

}