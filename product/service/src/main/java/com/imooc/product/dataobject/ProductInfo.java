package com.imooc.product.dataobject;



import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInfo {
    @Id
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
