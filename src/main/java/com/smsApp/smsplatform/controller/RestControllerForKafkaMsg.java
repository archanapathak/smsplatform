package com.smsApp.smsplatform.controller;


import com.smsApp.smsplatform.model.Employee;
import com.smsApp.smsplatform.service.KafkaMsgPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class RestControllerForKafkaMsg {
     @Autowired
    private KafkaMsgPublisher kafkaMsgPublisher;
     @GetMapping("/publish/{message}")
     public ResponseEntity<?> publishMessage(@PathVariable  String message){
       try {
           kafkaMsgPublisher.sendMessageToTopic(message);
           return ResponseEntity.ok("message published successfully");
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
     }

    @GetMapping("/publish")
    public void publishMessage1(@RequestBody Employee employee){

            kafkaMsgPublisher.sendMessageToTopic2(employee);

    }
}
