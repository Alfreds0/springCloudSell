package com.imooc.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor//生成带有必需参数的构造函数
public enum ProductStatusEnum {
    /**
     * 上架
     */
    UP(0,"在架"),
    DOWN(1,"下架");

    private final Integer code;
    private final String message;

}
