package com.example.notice.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class FirebaseInit {
    private static final String path = "danjinae-8b6ca-firebase-adminsdk-l0b9i-f00e5570f8.json";

    @PostConstruct
    public void init(){
        try{
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(path).getInputStream())).build();

            if(FirebaseApp.getApps().isEmpty()){
                FirebaseApp.initializeApp(options);
            }
        }catch (IOException e){
            e.printStackTrace();

        }
    }

}