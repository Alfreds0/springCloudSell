package com.imooc.order.dataobject;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    /** 商品名称. */
    private String productName;
    /** 当前价格,单位分. */
    private BigDecimal productPrice;
    /** 数量 */
    private Integer productQuantity;
    /** 小图 */
    private String productIcon;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
