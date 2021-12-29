package com.imooc.order.repository;


import com.imooc.order.OrderApplication;
import com.imooc.order.OrderApplicationTest;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void save() {
        OrderMaster orderMaster = OrderMaster.builder()
                .orderId("123457")
                .buyerName("张三")
                .buyerPhone("1234567911")
                .buyerAddress("陕西")
                .buyerOpenid("1100")
                .orderAmount(new BigDecimal("2.2"))
                .orderStatus(OrderStatusEnum.NEW.getCode())
                .payStatus(PayStatusEnum.WAIT.getCode())
                .build();
        OrderMaster save = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(save);
    }
}