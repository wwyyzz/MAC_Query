package com.wj.MAC_Query;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MacQueryApplication {

    public static void main(String[] args) {

        SpringApplication.run(MacQueryApplication.class, args);
    }

}
