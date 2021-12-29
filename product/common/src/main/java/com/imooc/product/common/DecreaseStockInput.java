package com.imooc.product.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DecreaseStockInput {
    private String productId;
    private Integer productQuantity;
}
