package com.imooc.order.repository;


import com.imooc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-05-07 14:35
 * @author Administrator
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

     List<OrderDetail> findByOrderId(String orderId);
}
