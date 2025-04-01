package com.smsApp.smsplatform.repository;

import com.smsApp.smsplatform.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Users,Integer> {
    Users getUsersByUsernameAndPassword(String username, String password);
}
