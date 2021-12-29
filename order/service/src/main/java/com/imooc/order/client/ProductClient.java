//package com.imooc.order.client;
//
//import com.imooc.order.dataobject.ProductInfo;
//import com.imooc.order.dataobject.dto.CartDto;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import java.util.List;
//
//@FeignClient(name = "product")
//public interface ProductClient {
//    @GetMapping("/msg")
//    String productMsg();
//
//    @PostMapping("/product/listForOrder")
//    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);
//
//    /**
//     * 扣库存
//     * @param cartDtoList
//     * @return
//     */
//    @PostMapping("/product/decreaseStock")
//    void decreaseStock(@RequestBody List<CartDto> cartDtoList);
//}
