package com.yzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class YzyApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(YzyApplication.class);
    }
}
