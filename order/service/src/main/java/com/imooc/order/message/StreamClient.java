package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    String INPUT = "myMessage";
    String INPUT2 = "myMessage2";
    @Input(StreamClient.INPUT)
    SubscribableChannel inputChannel();

    @Output(StreamClient.INPUT)
    MessageChannel outputChannel();
    @Input(StreamClient.INPUT2)
    SubscribableChannel inputChannel2();

    @Output(StreamClient.INPUT2)
    MessageChannel outputChannel2();

}
