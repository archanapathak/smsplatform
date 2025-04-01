package com.smsApp.smsplatform.service;

import org.springframework.stereotype.Service;

@Service
public interface SendmsgService {

    public String sendMessage(String username, String password,Long mobile, String message);
}
