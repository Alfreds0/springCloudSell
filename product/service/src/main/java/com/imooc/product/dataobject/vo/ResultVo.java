package com.imooc.product.dataobject.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = -745045224966921245L;
    private Integer code;
    private String msg;
    private T data;
}
