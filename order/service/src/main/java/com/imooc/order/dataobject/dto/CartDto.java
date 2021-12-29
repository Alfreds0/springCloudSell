package com.imooc.order.dataobject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CartDto {
    private String productId;
    private Integer productQuantity;
}
