package com.imooc.order.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.dto.OrderMasterDto;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderFormToOrderMasterDtoConverter {
    public static OrderMasterDto convert(OrderForm orderForm) {
        Gson gson = new Gson();
        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            orderDetailList=gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
           log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        OrderMasterDto orderMasterDto = OrderMasterDto.builder()
                .buyerName(orderForm.getName())
                .buyerPhone(orderForm.getPhone())
                .buyerAddress(orderForm.getAddress())
                .buyerOpenid(orderForm.getOpenId())
                .orderDetailList(orderDetailList)
                .build();

        return orderMasterDto;
    }

}
