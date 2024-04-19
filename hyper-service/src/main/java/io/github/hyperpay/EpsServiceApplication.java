package io.github.hyperpay;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class EpsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpsServiceApplication.class, args);
    }

}
