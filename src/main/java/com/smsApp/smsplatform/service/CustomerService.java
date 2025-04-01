package com.smsApp.smsplatform.service;

import com.smsApp.smsplatform.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Users getAccount_id(String username, String password);

}
