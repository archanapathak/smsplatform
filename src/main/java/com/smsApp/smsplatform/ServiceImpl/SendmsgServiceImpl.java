package com.smsApp.smsplatform.ServiceImpl;
import com.smsApp.smsplatform.model.SendMsg;
import com.smsApp.smsplatform.repository.sendMsgRepository;
import com.smsApp.smsplatform.service.SendmsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.sql.Timestamp;

@Service
public class SendmsgServiceImpl implements SendmsgService {
    @Autowired
    sendMsgRepository sendMsgRepository;
    @Override
    public String sendMessage(String username, String password, Long mobile, String message) {
        SendMsg msg = new SendMsg();
        msg.setMobile(mobile);
        msg.setMessage(message);
        Date date = new Date();

        // getting the object of the Timestamp class
        Timestamp ts = new Timestamp(date.getTime());
        msg.setReceived_ts(ts);msg.setStatus("New");
        SendMsg res = sendMsgRepository.save(msg);
        System.out.println("msg saved "+res);
        return "saved";
    }
}
