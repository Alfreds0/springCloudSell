package com.imooc.order.controller;

import com.imooc.order.dataobject.dto.OrderMasterDto;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    //@GetMapping("/sendMessage")
    //public void process() {
    //    String message = "now " + new Date();
    //    streamClient.outputChannel().send(MessageBuilder.withPayload(message).build());
    //}
    /**
     * 发送orderDto对象
     */
    @GetMapping("/sendMessage")
    public void process() {
        OrderMasterDto orderMasterDto = OrderMasterDto.builder()
                .orderId("1234").build();
        streamClient.outputChannel().send(MessageBuilder.withPayload(orderMasterDto).build());
    }
}
