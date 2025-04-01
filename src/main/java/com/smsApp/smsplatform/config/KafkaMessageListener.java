package com.smsApp.smsplatform.config;


import com.smsApp.smsplatform.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
public class KafkaMessageListener {
      Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);
    @KafkaListener(topics="demo-topic",groupId = "demo-consumer-group")
    public void consume(String message){
        logger.info("consumer consumed the mssges received {}",message);
    }

    @KafkaListener(topics="mytopic1",groupId = "demo-consumer-group-1",containerFactory = "kafkaListenerContainerFactory1")
    public void consume(Employee employee){
        logger.info("consumer consumed the mssges received {}",employee.toString());
    }
}
