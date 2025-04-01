package com.smsApp.smsplatform.repository;


import com.smsApp.smsplatform.model.SendMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sendMsgRepository extends JpaRepository<SendMsg,Long> {
}
