package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Payment;
import com.example.hotelbooking.pojo.PaymentPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    List<Payment> findAll();
    Payment findById(Integer id);
    Payment save(PaymentPojo paymentPojo);
    Payment update(PaymentPojo paymentPojo);
    void deleteById(Integer id);

}
