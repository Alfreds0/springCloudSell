package com.imooc.order.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;
    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;
    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家openId
     */
    @NotEmpty(message = "openId必填")
    private String openId;

    /**
     * 购物车字段
     */
    @NotEmpty(message = "购物车必填")
    private String items;

}
