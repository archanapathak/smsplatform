package com.smsApp.smsplatform.controller;


import com.smsApp.smsplatform.model.CustomerMsgDetails;
import com.smsApp.smsplatform.model.Users;
import com.smsApp.smsplatform.service.KafkaMsgPublisher;
import com.smsApp.smsplatform.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/telco")
public class SendMsgController {
    @Autowired
    KafkaMsgPublisher kafkaMsgPublisher;
    @Autowired
    DatabaseService sendmsgService;
    @PostMapping("/sendMsg")
    public  ResponseEntity<String> sendMsg(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("mobile") Long mobile,
                          @RequestParam("message") String message
                          ) {
        UUID uid = UUID.randomUUID();// checking the value of random UUID
        System.out.println("Random UUID value: " + uid);

        //*calling databse second api for user validation
        //validate the user and get the id
        //http://localhost:8082/customer/validate?username=archana&&password=abc

        HashMap<String, String> urivariables = new HashMap<>();
        urivariables.put("username", username);
        urivariables.put("password", password);
        System.out.println(urivariables);
        ResponseEntity<Users> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/customer/validate/username/{username}/password/{password}",
                Users.class, urivariables);
        Users users = responseEntity.getBody();
        System.out.println("account id of user ====" + users.getAccount_id());
//*******************************************************************************************
        // producer code should come here
        CustomerMsgDetails msgdetails = new CustomerMsgDetails();
        msgdetails.setAck_id(uid.toString());
        msgdetails.setAccount_id(users.getAccount_id());
        msgdetails.setMobile(mobile);
        msgdetails.setMessage(message);
        System.out.println("Msg going tobe published to kafka topic : " +msgdetails);

        kafkaMsgPublisher.sendMessageToTopic3(msgdetails);
        //*********************************************************
        // sendmsgService.sendMessage(username,password,mobile,message);

       return ResponseEntity.status(HttpStatus.ACCEPTED).body( "status "+  "Acknowledgement ID"+uid.toString());

    }

}
