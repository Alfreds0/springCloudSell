package com.imooc.order.message;

import com.imooc.order.dataobject.dto.OrderMasterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    //@StreamListener(StreamClient.INPUT)
    //public void process(Object message) {
    //    log.info("StreamReceiver:{}",message);
    //}

    /**
     * 接收orderDto对象
     * @SendTo 处理完返回消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderMasterDto message) {
        log.info("StreamReceiver:{}",message);
        return "received.";
    }
    /**
     * 接收process返回的消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT2)
    public void process2(String message) {
        log.info("StreamReceiver2:{}",message);
    }
}
