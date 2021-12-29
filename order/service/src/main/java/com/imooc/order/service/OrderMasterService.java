package com.imooc.order.service;

import com.imooc.order.dataobject.dto.OrderMasterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderMasterService {

    /**
     * 创建订单
     */
    OrderMasterDto create(OrderMasterDto orderMasterDto);


}
