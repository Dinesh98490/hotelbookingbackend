package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Payment;
import com.example.hotelbooking.pojo.PaymentPojo;

import java.util.List;


public interface PaymentService {
    List<Payment> findAll();
    Payment findById(Integer id);
    Payment save(PaymentPojo paymentPojo);
    Payment update(Integer id, PaymentPojo paymentPojo);
    void deleteById(Integer id);

}
