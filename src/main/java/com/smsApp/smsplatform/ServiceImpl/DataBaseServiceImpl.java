package com.smsApp.smsplatform.ServiceImpl;
import com.smsApp.smsplatform.model.SendMsg;
import com.smsApp.smsplatform.repository.DataBaseRepository;
import com.smsApp.smsplatform.service.DatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.sql.Timestamp;

@Service
@Slf4j
public class DataBaseServiceImpl implements DatabaseService {
    @Autowired
    DataBaseRepository sendMsgRepository;
    @Override
    public SendMsg sendMessage( int account_id,Long mobile, String message) {
        SendMsg msg = new SendMsg();
        msg.setAccount_id(account_id);
        msg.setMobile(mobile);
        msg.setMessage(message);
        Date date = new Date();

        // getting the object of the Timestamp class
        Timestamp ts = new Timestamp(date.getTime());
        msg.setReceived_ts(ts);msg.setStatus("New");
        SendMsg res = sendMsgRepository.save(msg);
        System.out.println("msg saved "+res);
        return res;
    }

}
