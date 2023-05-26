package org.lnu.teaching.software.systems.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class DbConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbConsumerApplication.class, args);
    }

    @Scheduled(fixedRate = 1 * 60 * 1000)
    public void keepAlive() {
    }
}
