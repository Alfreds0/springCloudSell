package com.imooc.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor//生成带有必需参数的构造函数
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISH(1,"完成"),
    CANAl(2,"取消");

    private final Integer code;
    private final String message;


}
