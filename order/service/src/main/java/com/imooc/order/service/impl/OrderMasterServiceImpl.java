package com.imooc.order.service.impl;



import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dataobject.dto.CartDto;
import com.imooc.order.dataobject.dto.OrderMasterDto;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.service.OrderMasterService;
import com.imooc.order.utils.KeyUtil;
import com.imooc.product.client.ProductClient;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutPut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;
    @Override
    @Transient
    public OrderMasterDto create(OrderMasterDto orderMasterDto) {
        //如果是秒杀场景
        //1.读redis库存信息，判断库存减库存
        //2.减库存并将新值重新设置进redis 有高并发需要加redis锁
        //3.订单入库异常try catch 手动回滚redis
        String orderId = KeyUtil.getUniqueKey();
        //1.查询商品信息（调用商品服务）
        List<String> productIdList= orderMasterDto.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutPut> productInfoOutPutList = productClient.listForOrder(productIdList);
        //2.计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderMasterDto.getOrderDetailList()) {
            for (ProductInfoOutPut productInfoOutPut : productInfoOutPutList) {
                if (productInfoOutPut.getProductId().equals(orderDetail.getProductId())) {
                    //单价*数量
                    orderAmout=productInfoOutPut.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfoOutPut,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.getUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
            }
        //3.扣库存（调用商品服务）
        List<DecreaseStockInput> decreaseStockInputList = orderMasterDto.getOrderDetailList().stream().map(e ->
                new DecreaseStockInput(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);
        //4.订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderMasterDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderMasterDto, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderMasterDto;

    }


}
