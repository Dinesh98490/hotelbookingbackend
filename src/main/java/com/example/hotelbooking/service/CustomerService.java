package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Customer;
import com.example.hotelbooking.pojo.CustomerPojo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomer(Integer id);
    Customer saveCustomer(CustomerPojo customerPojo);
    Customer updateCustomer(CustomerPojo customerPojo);
    void deleteCustomer(Integer id);


}

