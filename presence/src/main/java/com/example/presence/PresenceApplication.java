package com.example.presence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PresenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PresenceApplication.class, args);
//		try {
//			BrokerService broker = new BrokerService();
//			broker.addConnector("tcp://0.0.0.0:8082");
//			broker.start();
//		} catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

}

