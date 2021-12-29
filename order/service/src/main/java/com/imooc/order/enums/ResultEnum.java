package com.imooc.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor//生成带有必需参数的构造函数
public enum ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空");

    private final Integer code;
    private final String message;


}
