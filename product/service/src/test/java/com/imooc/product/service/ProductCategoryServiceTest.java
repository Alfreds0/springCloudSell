package com.imooc.product.service;

import com.imooc.product.ProductApplicationTest;
import com.imooc.product.dataobject.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductCategoryServiceTest extends ProductApplicationTest {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryTypeIn = productCategoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        assertTrue(byCategoryTypeIn.size()>0);
    }

    @Test
    public void save() {
    }
}