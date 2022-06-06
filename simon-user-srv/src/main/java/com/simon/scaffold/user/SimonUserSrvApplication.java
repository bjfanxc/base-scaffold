package com.simon.scaffold.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimonUserSrvApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimonUserSrvApplication.class, args);
    }
}
