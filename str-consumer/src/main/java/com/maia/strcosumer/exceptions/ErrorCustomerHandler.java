package com.maia.strcosumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomerHandler implements KafkaListenerErrorHandler {


    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.error("EXCEPTION_HANDLER ::: Exception Capturada!");

        log.error("EXCEPTION_HANDLER ::: Exception Message Error:: {}",e.getMessage());
        log.error("EXCEPTION_HANDLER ::: payload :: {}",message.getPayload());
        log.error("EXCEPTION_HANDLER ::: Headers :: {}",message.getHeaders());

        return null;
    }

//    @Override
//    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//    }
}
