package com.smsApp.smsplatform.controller;


import com.smsApp.smsplatform.model.Users;
import com.smsApp.smsplatform.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
   private CustomerService customerService;



    @GetMapping("/validate/username/{username}/password/{password}")
    public Users validateUser(@PathVariable("username") String username,
                              @PathVariable("password") String password) {
        // Implementation to search users based on the provided name
        return customerService.getAccount_id(username,password);
       // return ResponseEntity.ok(users);
    }

}
