package com.explobit.server.crawler.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service
public class BinanceConfig {

    @Value("${firebase-database.database-url}")
    private String firebaseUrl;
    @Value("${firebase-database.json-file-name}")
    private String firebaseJsonName;

    @PostConstruct
    public void firebaseInitialize() throws IOException {
        Resource resource = new ClassPathResource(firebaseJsonName);
        InputStream inputStream = resource.getInputStream();

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .setDatabaseUrl(firebaseUrl)
                .build();

        FirebaseApp.initializeApp(options);
    }

}
