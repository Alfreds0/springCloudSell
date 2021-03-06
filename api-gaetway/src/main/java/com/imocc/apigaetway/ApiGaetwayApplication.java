package com.imocc.apigaetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;


@SpringBootApplication
@EnableZuulProxy
public class ApiGaetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGaetwayApplication.class, args);
    }

    //@ConfigurationProperties("zuul")
    //@RefreshScope
    //public ZuulProperties zuulProperties() {
    //    return new ZuulProperties();
    //}
}
