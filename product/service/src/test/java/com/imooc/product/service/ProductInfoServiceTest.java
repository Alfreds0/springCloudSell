package com.imooc.product.service;

import com.imooc.product.ProductApplicationTest;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutPut;
import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductInfoServiceTest extends ProductApplicationTest {
    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findUpAll() {

        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertTrue(productInfoList.size()>0);
    }

    @Test
    public void findList() {

        List<ProductInfoOutPut> productInfoList = productInfoService.findList(Arrays.asList("157875196366160022","157875227953464068"));
        System.out.println(productInfoList);
        Assert.assertTrue(productInfoList.size()>0);
    }

    @Test
    public void decreaseStock() {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("157875196366160022", 2);
        productInfoService.decreaseStock(Arrays.asList(decreaseStockInput));

    }
}