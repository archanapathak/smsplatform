package com.smsApp.smsplatform.repository;


import com.smsApp.smsplatform.model.SendMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataBaseRepository extends JpaRepository<SendMsg,Long> {

    @Query(value = "SELECT * FROM send_msg", nativeQuery = true)
    List<SendMsg> listmsg();
}


