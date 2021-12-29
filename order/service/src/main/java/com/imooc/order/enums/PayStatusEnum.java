package com.imooc.order.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor//生成带有必需参数的构造函数
public enum PayStatusEnum {
    /**
     * 上架
     */
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    private final Integer code;
    private final String message;

}
