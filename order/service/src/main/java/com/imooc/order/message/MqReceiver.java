package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收mq消息
 *
 * @author admin
 */
@Slf4j
@Component
public class MqReceiver {

    //1.@RabbitListener(queues = "myQueue")
    //2.自动创建队列@RabbitListener(queuesToDeclare =@Queue("myQueue"))
    //3.自动创建队列exchage和queue绑定 @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"), exchange = @Exchange("myExchange")))
    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueue"), exchange = @Exchange("myExchange")))
    public void message(String message) {
        log.info("mqReceiver{}", message);
    }

    /**
     * 数码供应商接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
           ))
    public void computerOrder(String message) {
        log.info("computer mqReceiver:{}", message);
    }

    /**
     * 水果供应商接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
            ))
    public void fruitOrder(String message) {
        System.out.println('s');
        log.info("fruit mqReceiver:{}", message);
    }
}
