package com.smsApp.smsplatform.service;

import com.smsApp.smsplatform.model.SendMsg;
import org.springframework.stereotype.Service;

@Service
public interface DatabaseService {

    public SendMsg sendMessage(int account_id, Long mobile, String message);


}
