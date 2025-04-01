package com.smsApp.smsplatform.service;


import com.smsApp.smsplatform.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
public class KafkaMsgPublisher {
    @Autowired
    private KafkaTemplate<String,Object>  template;

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("demo-topic2", message);
       future.whenComplete((result,ex)->{
           if(ex==null){
               System.out.println("sent message =[" +message +
                       "] with offset =[" + result.getRecordMetadata().offset()+"]");
           }
           else{
               System.out.println("unable to send message =[" +
                       message +"] due to :" + ex.getMessage());
           }
        });
    }

    public void sendMessageToTopic2(Employee employee) {
        try{
        CompletableFuture<SendResult<String, Object>> future = template.send("mytopic1", employee);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("sent message =[" + employee +
                        "] with offset =[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("unable to send message =[" +
                        employee.toString() + "] due to :" + ex.getMessage());
            }
        });
    }catch (Exception e){
            System.out.println("error msg : "+e.getMessage());
        }
    }

}
