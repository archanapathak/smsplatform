package com.smsApp.smsplatform.config;


import com.smsApp.smsplatform.ServiceImpl.DataBaseServiceImpl;
import com.smsApp.smsplatform.model.CustomerMsgDetails;
import com.smsApp.smsplatform.model.Employee;
import com.smsApp.smsplatform.model.SendMsg;
import com.smsApp.smsplatform.model.Users;
import com.smsApp.smsplatform.repository.CustomerRepository;
import com.smsApp.smsplatform.repository.DataBaseRepository;
import com.smsApp.smsplatform.service.DatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class KafkaMessageListener {
    @Autowired
    DataBaseServiceImpl dbserviceimpl;
    @Autowired
    DataBaseRepository dataBaseRepository;

      Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics="telcotopictest1",groupId = "demo-consumer-group-1",containerFactory = "kafkaListenerContainerFactory1")
    public void consume(CustomerMsgDetails customerMsgDetails) throws InterruptedException {
        logger.info("consumer consumed the mssges received {}",customerMsgDetails.toString());
        SendMsg r = dbserviceimpl.sendMessage(customerMsgDetails.getAccount_id(), customerMsgDetails.getMobile(), customerMsgDetails.getMessage());

        System.out.println("consumed msg sent to db");
        testthread();


    }

    @Async("asyncTaskExecutor")
    public void testthread( ) throws InterruptedException {
        Thread.sleep(4000L);
        List<SendMsg> list = dataBaseRepository.listmsg();
        log.info("test asyn task " + list.toString());

    }


}
