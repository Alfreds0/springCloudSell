package com.imooc.product.service;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutPut;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    List<ProductInfo> findUpAll();

    List<ProductInfoOutPut> findList(List<String> asList);

    void decreaseStock(List<DecreaseStockInput> cartDtoList);
}
