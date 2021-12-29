package com.imooc.order.converter;


import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dataobject.dto.OrderMasterDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMasterToOrderMasterDtoConverter {
    public static OrderMasterDto convert(OrderMaster orderMaster) {
        OrderMasterDto orderMasterDto = new OrderMasterDto();
        BeanUtils.copyProperties(orderMaster,orderMasterDto);
        return orderMasterDto;
    }
    public static List<OrderMasterDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
