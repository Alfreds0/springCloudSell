package com.imooc.product.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInfoOutPut {

    /** 商品id. */
    private String productId;
    /** 商品名字. */
    private String productName;
    /** 单价. */
    private BigDecimal productPrice;
    /** 库存. */
    private Integer productStock;
    /** 描述. */
    private String productDescription;
    /** 小图. */
    private String productIcon;
    /** 商品状态,0正常1下架. */
    private Integer productStatus;
    /** 商品状态,0正常1下架. */
    private Integer categoryType;
}
