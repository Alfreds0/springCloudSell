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
public class OrderMaster {
    @Id
    private String orderId;
    /** 买家名字. */
    private String buyerName;
    /** 买家电话. */
    private String buyerPhone;
    /** 买家地址. */
    private String buyerAddress;
    /** 买家微信openid. */
    private String buyerOpenid;
    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认未支付. */
    private Integer payStatus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    //@Transient该注解可以忽略字段，jpa不建议这样弄
    //@Transient
    //private List<OrderDetail> orderDetailList;
}
