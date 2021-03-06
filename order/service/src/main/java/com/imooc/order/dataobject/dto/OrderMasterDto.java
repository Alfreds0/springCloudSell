package com.imooc.order.dataobject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.imooc.order.dataobject.OrderDetail;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderMasterDto {

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

    private List<OrderDetail> orderDetailList;

}
