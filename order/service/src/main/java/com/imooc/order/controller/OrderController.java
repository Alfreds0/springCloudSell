package com.imooc.order.controller;


import com.imooc.order.converter.OrderFormToOrderMasterDtoConverter;
import com.imooc.order.dataobject.dto.OrderMasterDto;
import com.imooc.order.dataobject.vo.ResultVo;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderMasterService;
import com.imooc.order.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderMasterService orderMasterService;

    /**
     * 1.参数校验
     * 2.查询商品信息（调用商品服务）
     * 3.计算总价
     * 4.扣库存（调用商品服务）
     * 5.订单入库
     */
    @PostMapping("/create")
    private ResultVo create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderMasterDto orderMasterDto = OrderFormToOrderMasterDtoConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderMasterDto.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderMasterDto orderMasterDto1 = orderMasterService.create(orderMasterDto);
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderMasterDto1.getOrderId());

        return ResultVoUtil.success(map);

    }
}
