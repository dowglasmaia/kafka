package com.maia.strcosumer.listeners;


import com.maia.strcosumer.listeners.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.security.InvalidAlgorithmParameterException;

@Log4j2
@Component
public class StrConsumerListener {


    @KafkaListener(groupId = "group-0", topicPartitions = {
            @TopicPartition(topic = "str-topic", partitions = {"1"})}, containerFactory = "strContainerFactory")
    public void analytics(String message) {
        log.info("ANALYTICS :: Receive message {}", message);

    }

    @StrConsumerCustomListener(groupId = "0")
    public void create(String message) {
        log.info("CREATE :: Receive message {}", message);
    }

    @StrConsumerCustomListener(groupId = "1")
    public void logs(String message) {
        log.info("LOG :: Receive message {}", message);
    }

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "1")
    public void history(String message) {
        log.info("HISTORY :: Receive message {}", message);

        throw new InvalidAlgorithmParameterException("Error no HISTORY ");
    }

    @SneakyThrows
    @KafkaListener(
            groupId = "group-2",
            topics = "str-topic",
            containerFactory = "validaMessageContainerFactory",
            errorHandler = "errorCustomerHandler")
    public void inteceptor(String message) {
        log.info("INTECEPTOR :: Receive message {}", message);

        throw new InvalidAlgorithmParameterException("Error no INTECEPTOR");
    }

}
