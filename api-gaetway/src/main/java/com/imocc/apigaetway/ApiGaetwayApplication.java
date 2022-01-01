package com.imocc.apigaetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
public class ApiGaetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGaetwayApplication.class, args);
    }

}
