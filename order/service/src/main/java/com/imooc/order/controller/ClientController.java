//package com.imooc.order.controller;
//
//import com.google.common.cache.LoadingCache;
////import com.imooc.order.client.ProductClient;
//import com.imooc.order.dataobject.ProductInfo;
//import com.imooc.order.dataobject.dto.CartDto;
//import com.imooc.product.client.ProductClient;
//import com.imooc.product.common.DecreaseStockInput;
//import com.imooc.product.common.ProductInfoOutPut;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 获取其他接口地址数据
// */
//@RestController
//@Slf4j
//public class ClientController {
//    @Autowired
//    private ProductClient productClient;
//
//    //@Autowired
//    //private LoadBalancerClient loadBalancerClient;
//    //
//    //@Autowired
//    //private RestTemplate restTemplate;
//
//    @GetMapping("/getProductMsg")
//    public String getProductMsg() {
//        //1.第一种方式 直接使用 restTemplate 地址写死
//        //RestTemplate restTemplate = new RestTemplate();
//        //String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//        //2.第二种方式 通过loadBalancerClient 获取地址和端口
//        //ServiceInstance product = loadBalancerClient.choose("PRODUCT");
//        //RestTemplate restTemplate = new RestTemplate();
//        //String format = String.format("http://%s:%s", product.getHost(), product.getPort())+"/msg";
//        //String response = restTemplate.getForObject(format, String.class);
//        //3.第三种方式
//        //String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
//        //Feign第一种方式
//        //String response = productClient.productMsg();
//        //log.info("response:{}",response);
//        return "response";
//    }
//
//    @GetMapping("/getProductIdList")
//    public String getProductIdList() {
//        List<ProductInfoOutPut> productInfos =  productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
//        System.out.println(productInfos);
//        return "productInfos.toString()";
//    }
//
//    @GetMapping("/ProductDecreaseStock")
//    public String decreaseStock() {
//        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("157875227953464068", 2);
//        productClient.decreaseStock(Arrays.asList(decreaseStockInput));
//        return "decreaseStock";
//    }
//}
