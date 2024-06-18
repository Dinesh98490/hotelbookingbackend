package com.example.hotelbooking.repository;

import com.example.hotelbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {


}
