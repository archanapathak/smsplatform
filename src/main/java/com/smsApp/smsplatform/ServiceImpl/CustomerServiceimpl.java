package com.smsApp.smsplatform.ServiceImpl;


import com.smsApp.smsplatform.model.Users;
import com.smsApp.smsplatform.repository.CustomerRepository;
import com.smsApp.smsplatform.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Users getAccount_id(String username, String password) {
        Users res = customerRepository.getUsersByUsernameAndPassword(username, password);
        System.out.println("user found " +res);
        return res;
    }
}
