package com.example.hotelbooking.repository;

import com.example.hotelbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
    Optional<Customer> getUserByEmail(String email);


}
