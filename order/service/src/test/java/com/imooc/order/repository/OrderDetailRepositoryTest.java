package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTest;
import com.imooc.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTest {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void save() {
        OrderDetail orderDetail = OrderDetail.builder()
                .detailId("123457")
                .orderId("123456")
                .productId("157875196366160022")
                .productName("皮蛋粥")
                .productPrice(new BigDecimal("0.01"))
                .productQuantity(2)
                .productIcon("http://xxx.jpg")
                .build();
        OrderDetail save = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(save != null);

    }
}